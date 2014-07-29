package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rom4 on 04.07.14.
 * Creation time 18:48
 * Project name Departments
 */
public class SaveDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       DepartmentService departmentService, EmployeeService employeeService, Validator validator) throws IOException, ServletException {

        String saveStatus;
        String pageType;
        pageType = request.getParameter("pageType");

        Department dep = parseDepartmentFromRequest(request, pageType);
        if (dep != null) {
                saveStatus = processDepartment(dep, request, response, pageType, departmentService);
                if (saveStatus != null) {
                    request.getSession().setAttribute("saveStatus", saveStatus);
                    PageUtil.redirectToPage(request, response, "AddDepartment.html");
                }

        }
    }

    public Department parseDepartmentFromRequest(HttpServletRequest request, String pageType) {
        Department dep = new Department();
        dep.setName(request.getParameter("name"));
        dep.setCity(request.getParameter("city"));

        if (pageType.equals("edit")) {
            dep.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
        }
        return dep;
    }

    public void validateDepartment(HttpServletRequest request, HttpServletResponse response,
                                     Department dep, String pageType, List<ObjectError> errors) throws IOException, ServletException {

        for (ObjectError objectError : errors) {
            if (objectError instanceof FieldError) {
                request.setAttribute(((FieldError) objectError).getField() + "Error", objectError.getDefaultMessage());
            }
        }

            request.setAttribute("name", dep.getName());
            request.setAttribute("city", dep.getCity());
            request.setAttribute("pageType", "add");

            if (pageType.equals("edit")) {
                request.setAttribute("pageType", "edit");
                request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
            }
            PageUtil.forwardToPage(request, response, "editDepartment.jsp");
    }

    private String processDepartment(Department dep, HttpServletRequest request, HttpServletResponse response, String pageType, DepartmentService departmentService) throws IOException, ServletException {
        String saveStatus = null;

        try {
            request.getSession().setAttribute("saveStatus", "");
            if (pageType.equals("add")) {
                saveStatus = "Department " + dep.getName() +" was created";
            departmentService.create(dep);
            }
            else if (pageType.equals("edit")) {
                dep.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                saveStatus = "Department updated";
                departmentService.update(dep);
            }
        }
        catch (ValidateException e) {
            validateDepartment(request, response, dep, pageType,  e.getErrors());
            return null;
        }

        return saveStatus;
    }

}