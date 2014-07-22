package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;

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
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        List<Department> departments;
        try {
            departments = depDAO.getDepartments();
            request.setAttribute("Departments", departments);
            request.setAttribute("pageType", "add");
           /* if (request.getParameter("pageType") != null) {
                if (request.getParameter("pageType").equals("AddEmployeWithDep")) {
                    request.setAttribute("departmentID", request.getParameter("departmentID"));
                }
            }*/
            PageUtil.forwardToPage(request, response, "editEmploye.jsp");
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }




    }

}
