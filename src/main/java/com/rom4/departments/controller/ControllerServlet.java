package com.rom4.departments.controller;


import com.rom4.departments.dao.DAOFactory;
import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;

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
public class ControllerServlet extends HttpServlet {
    private final DepartmentDAO daoDep = DAOFactory.getDepartmentDAO();
    private final EmployeDAO daoEmp = DAOFactory.getEmployeDAO();

    private final HashMap<String, Handler> handlers = new HashMap<String, Handler>();
    {
      /*  handlers.put("AddDepartment",new AddDepartment());
        handlers.put("SaveDepartment",new SaveDepartment());
        handlers.put("SaveEmploye",new SaveEmploye());
        handlers.put("EditDepartment",new EditDepartment());
        handlers.put("EditEmploye",new EditEmploye());
        handlers.put("DeleteDepartment",new DeleteDepartment());
        handlers.put("DeleteEmploye",new DeleteEmploye());
        handlers.put("DepartmentList",new DepartmentList());
        handlers.put("Employers",new EmployersList());
        handlers.put("AddEmploye",new AddEmploye());
        handlers.put("Contacts",new Contacts());
        handlers.put("home",new MainPage());
*/
        handlers.put("AddDepartment.html",new AddDepartment());
        handlers.put("SaveDepartment",new SaveDepartment());
        handlers.put("SaveEmploye",new SaveEmploye());
        handlers.put("EditDepartment",new EditDepartment());
        handlers.put("EditEmploye",new EditEmploye());
        handlers.put("DeleteDepartment",new DeleteDepartment());
        handlers.put("DeleteEmploye",new DeleteEmploye());
        handlers.put("Departments.html",new DepartmentList());
        handlers.put("Employers.html",new EmployersList());
        handlers.put("AddEmploye.html",new AddEmploye());
        handlers.put("contact.html",new Contacts());
        handlers.put("home",new MainPage());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("uri " + req.getRequestURI());
       // System.err.println("url " + req.getRequestURL());
        //System.err.println("req.getParameter(page)" + req.getParameter("page"));

        Handler handler = handlers.get(req.getParameter("page"));

        if (handler != null) {
            handler.handle(req, resp, daoDep, daoEmp);
        }

        ServletContext sc = this.getServletContext();
        sc.log("go to "  + req.getRequestURI());
        //super.service(req, resp);
    }

   }

