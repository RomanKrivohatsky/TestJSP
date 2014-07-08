package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Department;
import com.rom4.departments.model.Employe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:35
 * Project name Departments
 */
public class EmployersList implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        List<Employe> employers = null;

        if (request.getParameter("pageType").equals("all") ) {
            try {
                employers = empDAO.getEmployes();
            } catch (AppExcepption a) {
                a.printStackTrace();
                request.setAttribute("errorStatus", a.getMessage());
                response.sendRedirect("ErrorPage.jsp");
                return;
            }
            request.setAttribute("Employers", employers);
        }
        else if  (request.getParameter("pageType").equals("byDepartment")) {
            try {
                employers = empDAO.getEmployes(Integer.parseInt(request.getParameter("departmentID")));
            } catch (AppExcepption a) {
                a.printStackTrace();
                request.setAttribute("errorStatus", a.getMessage());
                response.sendRedirect("ErrorPage.jsp");
                return;
            }
            request.setAttribute("Employers", employers);
            request.setAttribute("departmentID", request.getParameter("departmentID"));
        }

       RequestDispatcher rd;
        rd = request.getRequestDispatcher("Employers");
        rd.forward(request, response);

    }
}
