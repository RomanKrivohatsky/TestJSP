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
 * Created by rom4 on 04.07.14.
 * Creation time 18:48
 * Project name Departments
 */
public class SaveDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus = "Error on editing";

        Department dep = new Department();
        dep.setName(request.getParameter("name") );
        dep.setCity(request.getParameter("city"));

        if (request.getParameter("pageType").equals("add")) {
            try {
                saveStatus = "Department created";
                dep = depDAO.createDepartment(dep);
            } catch (AppException a) {
                a.printStackTrace();
                request.setAttribute("errorStatus",a.getMessage());
                PageUtil.forwardToPage(request, response, "ErrorPage");
                return;
            }

        }
        else if (request.getParameter("pageType").equals("edit")) {
            dep.setDepartmentID(  Integer.parseInt(request.getParameter("departmentID") ));
            try {
                saveStatus = "Department updated";
                depDAO.udpateDepartment(dep);
            } catch (AppException a) {
                a.printStackTrace();
                request.setAttribute("errorStatus", a.getMessage());
                PageUtil.forwardToPage(request, response, "ErrorPage");
                return;
            }

        }

        request.setAttribute("saveStatus", saveStatus);
        response.sendRedirect("SaveDepartment.jsp");

    }
}