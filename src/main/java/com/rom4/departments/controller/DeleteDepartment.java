package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 15:09
 * Project name Departments
 */
public class DeleteDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        String saveStatus ;

          try {
            saveStatus = "Department deleted";
            depDAO.deleteDepartment(Integer.parseInt(request.getParameter("departmentID")));
        } catch (AppException a) {
            a.printStackTrace();
            System.err.println(a.getMessage());
            //PageUtil.redirectToErrorPage(request, response, a.getMessage());
              request.setAttribute("errorStatus", a.getMessage());
              PageUtil.forwardToPage(request, response, "ErrorPage.jsp");
            return ;
        }

        request.setAttribute("saveStatus", saveStatus);
        PageUtil.forwardToPage(request, response, "SaveDepartment.jsp");

    }
}
