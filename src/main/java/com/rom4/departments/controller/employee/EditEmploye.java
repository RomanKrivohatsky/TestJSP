package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
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
 * Created by rom4 on 08.07.14.
 * Creation time 12:18
 * Project name Departments
 */
@Component("/EditEmployee.html")
public class EditEmploye implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Employee emp;
        Integer employeID;
        List<Department> departments;

        departments = departmentService.getList();
        employeID = Integer.parseInt(request.getParameter("employeID"));
        emp = employeeService.read(employeID);

        if (emp != null) {
            request.setAttribute("employeID", employeID);
            request.setAttribute("firstName", emp.getFirstName());
            request.setAttribute("lastName", emp.getLastName());
            request.setAttribute("email", emp.getEmail());
            request.setAttribute("salary", emp.getSalary());
            request.setAttribute("birthday", emp.getBirthday());
            request.setAttribute("departmentID", emp.getDepartment().getDepartmentID());
        }
        request.setAttribute("pageType", "edit");
        request.setAttribute("Departments", departments);
        request.getSession().setAttribute("page", this.getClass().getName());
        PageUtil.forwardToPage(request, response, "editEmploye.jsp");
    }
}
