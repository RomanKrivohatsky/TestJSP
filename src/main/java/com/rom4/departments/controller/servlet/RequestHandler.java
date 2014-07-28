package com.rom4.departments.controller.servlet;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.Contacts;
import com.rom4.departments.controller.common.MainPage;
import com.rom4.departments.controller.common.StatusPage;
import com.rom4.departments.controller.department.*;
import com.rom4.departments.controller.employee.*;
import com.rom4.departments.service.dao.EmployeeService;
import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by rom4 on 28.07.14.
 * Creation time 11:21
 * Project name Departments
 */

@Component("mainServlet")
public class RequestHandler implements HttpRequestHandler {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    private final HashMap<String, Handler> handlers = new HashMap<String, Handler>();
    {

        handlers.put("/AddDepartment.html",new AddDepartment());
        handlers.put("/SaveDepartment.html",new SaveDepartment());
        handlers.put("/SaveEmployee.html",new SaveEmploye());
        handlers.put("/EditDepartment.html",new EditDepartment());
        handlers.put("/EditEmployee.html",new EditEmploye());
        handlers.put("/DeleteDepartment.html",new DeleteDepartment());
        handlers.put("/DeleteEmployee.html",new DeleteEmploye());
        handlers.put("/Departments.html",new DepartmentList());
        handlers.put("/Employers.html",new EmployersList());
        handlers.put("/AddEmployee.html",new AddEmploye());
        handlers.put("/contact.html",new Contacts());
        handlers.put("/home.html",new MainPage());
        handlers.put("/StatusPage.html",new StatusPage());
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Handler handler = handlers.get(request.getRequestURI());

        if (handler != null) {
            handler.handle(request, response, departmentService, employeeService);
        }
    }
}
