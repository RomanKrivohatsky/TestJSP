package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 17:54
 * Project name Departments
 */
public class AddEmploye implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        System.err.println("add employe");

        List<Department> departments = null;
        try {
            departments = depDAO.getDepartments();
        } catch (AppException a) {
            a.printStackTrace();
            request.setAttribute("errorStatus", a.getMessage());
            response.sendRedirect("ErrorPage.jsp");
        }
        request.setAttribute("Departments", departments);

        if (request.getParameter("pageType").equals("AddEmployeWithDep")) {
            request.setAttribute("departmentID", request.getParameter("departmentID"));
        }

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("AddEmploye.jsp");
        rd.forward(request, response);
    }
}
