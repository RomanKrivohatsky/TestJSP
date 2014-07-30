package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 15:09
 * Project name Departments
 */
@Component ("/DeleteDepartment.html")
public class DeleteDepartment implements Handler {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Department department = departmentService.read(Integer.parseInt(request.getParameter("departmentID")));
        departmentService.delete(department);
        request.getSession().setAttribute("saveStatus", "Department deleted");
        PageUtil.redirectToPage(request, response, "Departments.html");


    }
}
