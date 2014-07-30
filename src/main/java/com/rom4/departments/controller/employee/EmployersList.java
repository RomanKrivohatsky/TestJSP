package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component("/Employers.html")
public class EmployersList implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> employers;

        request.getSession().setAttribute("saveStatus", "");

        if (request.getParameter("pageType") == null) {
            employers = employeeService.getList();
            request.setAttribute("Employers", employers);
        } else if (request.getParameter("pageType").equals("byDepartment")) {
            employers = employeeService.getList(Integer.parseInt(request.getParameter("departmentID")));
            request.setAttribute("Employers", employers);
            request.setAttribute("departmentID", request.getParameter("departmentID"));
        }
        PageUtil.forwardToPage(request, response, "employers.jsp");
    }
}
