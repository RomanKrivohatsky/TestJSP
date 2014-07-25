package com.rom4.departments.controller;


import com.rom4.departments.controller.common.Contacts;
import com.rom4.departments.controller.common.MainPage;
import com.rom4.departments.controller.common.StatusPage;
import com.rom4.departments.controller.department.*;
import com.rom4.departments.controller.employee.*;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.service.impl.DepartmentDAOImplHib;
import com.rom4.departments.service.impl.EmployeDAOImplHib;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by rom4 on 03.07.14.
 * Creation time 12:20
 * Project name Departments
 */
@Component
public class ControllerServlet extends HttpServlet {

    private final DepartmentDAO daoDep = new DepartmentDAOImplHib();
    private final EmployeDAO daoEmp = new EmployeDAOImplHib();

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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("uri " + req.getRequestURI());

        Handler handler = handlers.get(req.getRequestURI());

        if (handler != null) {
            handler.handle(req, resp, daoDep, daoEmp);
        }

        ServletContext sc = this.getServletContext();
        sc.log("go to "  + req.getRequestURI());
        //super.service(req, resp);
    }

   }

