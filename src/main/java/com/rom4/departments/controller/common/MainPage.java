package com.rom4.departments.controller.common;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 03.07.14.
 * Creation time 13:26
 * Project name Departments
 */
public class MainPage implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response , DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        System.err.println("main ");
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }
}
