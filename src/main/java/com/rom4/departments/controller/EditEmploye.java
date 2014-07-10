package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        if (request.getParameter("page").equals("EditEmployeWithDep")) {
            request.setAttribute("departmentID", request.getParameter("departmentID"));
        }

        rd = request.getRequestDispatcher("EditEmploye.jsp");
        rd.forward(request, response);
    }
}
