package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.stereotype.Component;

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
@Component
public class DepartmentList implements Handler {


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService, EmployeeService employeeService, Validator validator) throws IOException, ServletException {
        List<Department> departments ;
        departments = departmentService.getList();
        request.setAttribute("Departments", departments);
        PageUtil.forwardToPage(request, response, "departments.jsp");

     /*   try {
            departments = depDAO.getDepartments();
            request.setAttribute("Departments", departments);
            PageUtil.forwardToPage(request, response, "departments.jsp");
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }*/

    }
}
