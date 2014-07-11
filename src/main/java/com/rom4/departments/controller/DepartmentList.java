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
 * Created by rom4 on 03.07.14.
 * Creation time 12:18
 * Project name Departments
 */
public class DepartmentList implements Handler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        List<Department> departments = null;
        System.err.println("list");
        try {
            departments = depDAO.getDepartments();
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
            return;
        }
        request.setAttribute("Departments", departments);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("Departments.jsp");
        rd.forward(request, response);

    }
}
