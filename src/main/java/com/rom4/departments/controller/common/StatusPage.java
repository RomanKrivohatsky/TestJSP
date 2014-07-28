package com.rom4.departments.controller.common;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.service.dao.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 21.07.14.
 * Creation time 13:52
 * Project name Departments
 */
public class StatusPage implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService, EmployeeService employeeService) throws IOException, ServletException {
        PageUtil.forwardToPage(request, response, "statusPage.jsp");
    }
}
