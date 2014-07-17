package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rom4 on 04.07.14.
 * Creation time 18:48
 * Project name Departments
 */
public class SaveDepartment implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus = null;
        String validateError;
        String pageType;
        pageType = request.getParameter("pageType");

        Department dep = parseDepartmentFromRequest(request, pageType);
        if (dep != null) {
            validateError = validateDepartment(request, response, dep, pageType);
            if (validateError == null) {

                saveStatus = processEmploye(dep, request, response, pageType, depDAO);
                if (saveStatus != null) {
                    request.setAttribute("saveStatus", saveStatus);
                    PageUtil.forwardToPage(request, response, "SaveDepartment.jsp");
                }
                ;

            }
        }

    }
    public Department parseDepartmentFromRequest (HttpServletRequest request, String pageType) {

        Department dep = new Department();
        dep.setName(request.getParameter("name") );
        dep.setCity(request.getParameter("city"));

        if (pageType.equals("edit")) {
            dep.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
        }
        return dep;
    }

    public String validateDepartment (HttpServletRequest request, HttpServletResponse response, Department dep, String pageType) throws  IOException, ServletException{
            String validateError = null;

            Validator validator = new net.sf.oval.Validator();
            java.util.List violations = validator.validate(dep);

            if (!violations.isEmpty()) {
                validateError = ((ConstraintViolation) violations.get(0)).getMessage();

                RequestDispatcher rd;

                request.setAttribute("errorValidate", validateError);
                request.setAttribute("name", dep.getName());
                request.setAttribute("city", dep.getCity());

                if (pageType.equals("add")) {
                    rd = request.getRequestDispatcher("AddDepartment.jsp");
                    rd.forward(request, response);
                }
                else if (pageType.equals("edit")) {
                    request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
                    rd = request.getRequestDispatcher("EditDepartment.jsp");
                    rd.forward(request, response);
                }

            }
            return validateError;
    }

    private String  processEmploye (Department dep,  HttpServletRequest request, HttpServletResponse response, String pageType, DepartmentDAO depDAO) throws IOException, ServletException {
        String saveStatus = null;

        if (pageType.equals("add")) {
            try {
                saveStatus = "Department created";
                depDAO.createDepartment(dep);
            } catch (AppException a) {
                a.printStackTrace();
                request.setAttribute("errorStatus",a.getMessage());
                PageUtil.forwardToPage(request, response, "ErrorPage.jsp");
                return null;
            }

        }
        else if (pageType.equals("edit")) {
            dep.setDepartmentID(  Integer.parseInt(request.getParameter("departmentID") ));
            try {
                saveStatus = "Department updated";
                depDAO.udpateDepartment(dep);
            } catch (AppException a) {
                a.printStackTrace();
                request.setAttribute("errorStatus", a.getMessage());
                PageUtil.forwardToPage(request, response, "ErrorPage.jsp");
                return null;
            }

        }


        return saveStatus;
    }

}