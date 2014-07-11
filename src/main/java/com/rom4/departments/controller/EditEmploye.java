package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;
import com.rom4.departments.model.Employe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 12:18
 * Project name Departments
 */
public class EditEmploye implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        System.err.println("edit employe");
        RequestDispatcher rd;
        Employe emp= null;
        Integer employeID;

        List<Department> departments = null;
        try {
            departments = depDAO.getDepartments();
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
            return;
        }

        employeID = Integer.parseInt(request.getParameter("employeID"));

        try {
            emp = empDAO.readEmploye(employeID);
            if (emp != null) {
                request.setAttribute("employeID", employeID);
                request.setAttribute("firstName", emp.getFirstName());
                request.setAttribute("lastName", emp.getLastName());
                request.setAttribute("email", emp.getEmail());
                request.setAttribute("salary", emp.getSalary());
                request.setAttribute("birthday", emp.getBirthday());
            }

            if (request.getParameter("pageType").equals("EditEmployeDep")) {
                request.setAttribute("departmentID", request.getParameter("departmentID"));
            }

            request.setAttribute("Departments", departments);

            rd = request.getRequestDispatcher("EditEmploye.jsp");
            rd.forward(request, response);

        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
            return;
        }


    }
}
