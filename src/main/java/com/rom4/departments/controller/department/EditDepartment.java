package com.rom4.departments.controller.department;

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

/**
 * Created by rom4 on 07.07.14.
 * Creation time 14:40
 * Project name Departments
 */
public class EditDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService, EmployeeService employeeService, Validator validator) throws IOException, ServletException {

        Department dep;
        Integer departmentID;

        departmentID = Integer.parseInt(request.getParameter("departmentID"));
        dep = departmentService.read(departmentID);
        request.setAttribute("departmentID", departmentID);
        request.setAttribute("name", dep.getName());
        request.setAttribute("city", dep.getCity());
        request.setAttribute("pageType", "edit");
        PageUtil.forwardToPage(request, response, "editDepartment.jsp");

    }
}
