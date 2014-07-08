package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Employe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 19:58
 * Project name Departments
 */
public class SaveEmploye implements  Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus = "Error saving";

        Employe emp = new Employe();

        try {

            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setEmail(request.getParameter("email"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            emp.setBirthday(sdf.parse(request.getParameter("birthday")));
            emp.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (request.getParameter("pageType").equals("add")) {
            try {
                saveStatus = "Employe created";
                emp = empDAO.createEmploye(emp);
            }
            catch (AppExcepption a) {
                a.printStackTrace();
                saveStatus = a.getMessage();
                request.setAttribute("errorStatus",saveStatus);
                response.sendRedirect("ErrorPage");
                return;
            }
       }
        else if (request.getParameter("pageType").equals("edit")) {
            emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));

            try {
                saveStatus = "Employe updated";
                empDAO.udpateEmploye(emp);
            } catch (AppExcepption a) {
                 a.printStackTrace();
                saveStatus = a.getMessage();
                request.setAttribute("errorStatus",saveStatus);
                response.sendRedirect("ErrorPage");
                return;
            }

        }

        RequestDispatcher rd;
        request.setAttribute("saveStatus", saveStatus);
        rd = request.getRequestDispatcher("SaveEmploye");

        rd.forward(request, response);
    }
}
