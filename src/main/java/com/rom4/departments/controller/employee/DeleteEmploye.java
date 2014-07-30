package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 15:59
 * Project name Departments
 */
@Component("/DeleteEmployee.html")
public class DeleteEmploye implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        employeeService.delete(employeeService.read(Integer.parseInt(request.getParameter("EmployeID"))));
        request.getSession().setAttribute("saveStatus", "Employee deleted");
        request.getSession().setAttribute("page", this.getClass().getName());
        request.getSession().setAttribute("pageType", request.getParameter("pageType"));
        request.getSession().setAttribute("departmentID", request.getParameter("departmentID"));
        PageUtil.redirectToPage(request, response, "Employers.html");

    }
}
