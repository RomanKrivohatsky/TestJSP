package com.rom4.departments.controller;

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
public class MainPage implements Handler  {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response , DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        System.err.println("main ");
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("home");
        rd.forward(request, response);
/*
        String page;
        page =request.getParameter("page");
        if (page.equals("DepartmentList")) {

            response.sendRedirect("DepartmentsList");

            try {
                request.getServletContext().getRequestDispatcher("Departments.jsp").forward(request, response);
            }
            catch (ServletException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


        }
*/
    }
}
