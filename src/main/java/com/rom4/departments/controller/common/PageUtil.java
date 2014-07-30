package com.rom4.departments.controller.common;

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
        request.setAttribute("saveStatus",errorMessage);
        response.sendRedirect("StatusPage.html");
    }

    public static void redirectToPage(HttpServletRequest request, HttpServletResponse response, String pageName) throws IOException {
        response.sendRedirect( pageName);
    }

    public static void forwardToPage(HttpServletRequest request, HttpServletResponse response, String pageName) throws IOException, ServletException {
        RequestDispatcher rd;
        if (pageName.equals("index.jsp")) {
            rd = request.getRequestDispatcher(pageName);
        }
        else {
        rd = request.getRequestDispatcher("/WEB-INF/Views/"+pageName);
        }
        rd.forward(request, response);
    }
}
