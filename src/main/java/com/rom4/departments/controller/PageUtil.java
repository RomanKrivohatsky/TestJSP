package com.rom4.departments.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 11.07.14.
 * Creation time 12:05
 * Project name Departments
 */
public class PageUtil {
    public static void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws IOException {
        request.setAttribute("errorStatus",errorMessage);
        response.sendRedirect("ErrorPage.jsp");
    }


    public static void forwardToPage(HttpServletRequest request, HttpServletResponse response, String pageName) throws IOException, ServletException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(pageName);
        rd.forward(request, response);
    }


}
