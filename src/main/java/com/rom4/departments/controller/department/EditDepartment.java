package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 14:40
 * Project name Departments
 */
public class EditDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        Department dep ;
        Integer departmentID;

        departmentID = Integer.parseInt(request.getParameter("departmentID"));
        try {
            dep = depDAO.readDepartment(departmentID);
            if (dep != null) {
                request.setAttribute("departmentID", departmentID);
                request.setAttribute("name", dep.getName());
                request.setAttribute("city", dep.getCity());
                request.setAttribute("pageType", "edit");
                PageUtil.forwardToPage(request, response, "editDepartment.jsp");
            }
        } catch (AppException a) {
            a.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, a.getMessage());
        }
    }
}
