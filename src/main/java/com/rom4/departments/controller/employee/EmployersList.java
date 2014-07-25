package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Employe;
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
public class EmployersList implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {
        List<Employe> employers ;

        if (request.getParameter("pageType") == null)  {
            try {
                employers = empDAO.getEmployes();
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return;
            }
            request.setAttribute("Employers", employers);
        }
        else if  (request.getParameter("pageType").equals("byDepartment")) {
            try {
                employers = empDAO.getEmployes(Integer.parseInt(request.getParameter("departmentID")));
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return;
            }
            request.setAttribute("Employers", employers);
            request.setAttribute("departmentID", request.getParameter("departmentID"));
        }

        PageUtil.forwardToPage(request, response, "employers.jsp");

    }
}
