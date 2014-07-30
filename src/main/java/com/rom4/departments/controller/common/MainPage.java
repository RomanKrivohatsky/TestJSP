package com.rom4.departments.controller.common;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.stereotype.Component;

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
@Component("/home.html")
public class MainPage implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getSession().setAttribute("page", this.getClass().getName());
        request.getSession().setAttribute("saveStatus", "");
        request.getSession().setAttribute("pageType", "");
        PageUtil.forwardToPage(request, response, "index.jsp");
    }
}
