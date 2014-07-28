package com.rom4.departments.controller.common;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.service.dao.DepartmentServiceImpl;
import com.rom4.departments.service.dao.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:25
 * Project name Departments
 */
public class Contacts implements Handler
{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentServiceImpl departmentService, EmployeeService employeeService) throws IOException, ServletException {
        System.err.println("contacts");
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("contacts.jsp");
        rd.forward(request, response);
    }
}
