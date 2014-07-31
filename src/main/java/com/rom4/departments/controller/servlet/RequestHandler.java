package com.rom4.departments.controller.servlet;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.Contacts;
import com.rom4.departments.controller.common.MainPage;
import com.rom4.departments.controller.common.StatusPage;
import com.rom4.departments.controller.department.*;
import com.rom4.departments.controller.employee.*;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rom4 on 28.07.14.
 * Creation time 11:21
 * Project name Departments
 */

@Component("mainServlet")
public class RequestHandler implements HttpRequestHandler {

    /*@Autowired
    private ApplicationContext ctx;*/

    @Autowired
    private Map<String, Handler> handlerMap;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Handler handler = ctx.getBean(request.getRequestURI(), Handler.class);
        //handler.handle(request, response);

        Handler handler = handlerMap.get(request.getRequestURI());
        handler.handle(request, response);

    }
}
