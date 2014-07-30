package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:35
 * Project name Departments
 */
@Component("/Employers.html")
public class EmployersList implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> employers;
        Integer departmentID=0;

        //sets the info status, if employe deleted - show status, else empty status
        if (request.getSession().getAttribute("page")!=null && !request.getSession().getAttribute("page").equals(DeleteEmploye.class.getName())) {
            request.getSession().setAttribute("saveStatus", "");
        }

        request.getSession().setAttribute("page", this.getClass().getName());

        String pageTypeLocal = request.getParameter("pageType");
        String pageTypeGlobal = (String)request.getSession().getAttribute("pageType");
        pageTypeGlobal = pageTypeGlobal==null ?"":pageTypeGlobal;

        pageTypeLocal = !pageTypeGlobal.equals("") ? pageTypeGlobal:pageTypeLocal;

        if ( pageTypeLocal == null ||  pageTypeLocal.equals("")) {
            employers = employeeService.getList();
            request.setAttribute("Employers", employers);
        } else if (pageTypeLocal.equals("byDepartment")   ) {
            if (request.getParameter("departmentID") != null) {
                departmentID = Integer.parseInt(request.getParameter("departmentID"));
            }
            else if (request.getSession().getAttribute("departmentID")  != null ) {
                departmentID = Integer.parseInt((String)request.getSession().getAttribute("departmentID"));
            }
            employers = employeeService.getList(departmentID);
            request.setAttribute("Employers", employers);
            request.setAttribute("departmentID", departmentID);
        }

        PageUtil.forwardToPage(request, response, "employers.jsp");
    }
}
