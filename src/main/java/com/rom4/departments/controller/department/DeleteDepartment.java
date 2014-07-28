package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.EmployeeService;
import com.rom4.departments.service.dao.DepartmentService;
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
@Component
public class DeleteDepartment implements Handler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentService departmentService, EmployeeService employeeService) throws IOException, ServletException {
        //String saveStatus;

        Department department = departmentService.read(Integer.parseInt(request.getParameter("departmentID")));
        departmentService.delete(department);

      /*  try {
            saveStatus = "Department deleted";
            depDAO.deleteDepartment(Integer.parseInt(request.getParameter("departmentID")));
            request.getSession().setAttribute("saveStatus", saveStatus);
            PageUtil.redirectToPage(request, response, "StatusPage.html");
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }*/


    }
}
