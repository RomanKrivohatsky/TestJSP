package com.rom4.departments.controller;

import com.rom4.departments.service.dao.EmployeeService;
import com.rom4.departments.service.dao.DepartmentService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 03.07.14.
 * Creation time 12:11
 * Project name Departments
 */
public interface Handler {
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService, EmployeeService employeeService)
            throws IOException, ServletException;

}
