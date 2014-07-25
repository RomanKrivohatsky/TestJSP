package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
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
public class EditEmploye implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        Employee emp ;
        Integer employeID;
        List<Department> departments;

        try {
            departments = depDAO.getDepartments();
            employeID = Integer.parseInt(request.getParameter("employeID"));
            emp = empDAO.readEmploye(employeID);

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
            PageUtil.forwardToPage(request, response, "editEmploye.jsp");

        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }


    }
}
