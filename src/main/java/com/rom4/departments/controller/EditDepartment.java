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

/**
 * Created by rom4 on 07.07.14.
 * Creation time 14:40
 * Project name Departments
 */
public class EditDepartment implements  Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        System.err.println("edit");

        RequestDispatcher rd;
        Department dep = null;
        Integer departmentID;

        departmentID = Integer.parseInt(request.getParameter("departmentID"));
        try {
            dep = depDAO.readDepartment(departmentID);
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
            return;
        }

        if (dep != null) {
            request.setAttribute("departmentID", departmentID);
            request.setAttribute("name", dep.getName());
            request.setAttribute("city", dep.getCity());
        }

        rd = request.getRequestDispatcher("EditDepartment.jsp");
        rd.forward(request, response);
    }
}
