package com.rom4.departments.controller.servlet;

import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by rom4 on 28.07.14.
 * Creation time 11:53
 * Project name Departments
 */
@WebServlet(urlPatterns = {"*.html"} , name = "mainServlet")
public class AnnotatedHttpServlet extends HttpRequestHandlerServlet {

}
