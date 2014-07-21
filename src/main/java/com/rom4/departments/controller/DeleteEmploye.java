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
 * Creation time 15:59
 * Project name Departments
 */
public class DeleteEmploye implements  Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus;
        try {
            saveStatus = "Employee deleted";
            empDAO.deleteEmploye(Integer.parseInt(request.getParameter("EmployeID")));
            request.getSession().setAttribute("saveStatus", saveStatus);
            PageUtil.redirectToPage(request, response, "StatusPage.html");
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }


    }
}
