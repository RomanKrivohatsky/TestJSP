package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;

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
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService,EmployeeService employeeService, Validator validator) throws IOException, ServletException {

        List<Department> departments;
        departments = departmentService.getList();
        request.setAttribute("Departments", departments);
        request.setAttribute("pageType", "add");
        PageUtil.forwardToPage(request, response, "editEmploye.jsp");
    }

}
