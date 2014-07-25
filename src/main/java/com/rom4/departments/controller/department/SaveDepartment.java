package com.rom4.departments.controller.department;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.domain.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
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

        String saveStatus ;
        String validateError;
        String pageType;
        pageType = request.getParameter("pageType");

        Department dep = parseDepartmentFromRequest(request, pageType);
        if (dep != null) {
            validateError = validateDepartment(request, response, dep, pageType);
            if (validateError == null) {
                saveStatus = processDepartment(dep, request, response, pageType, depDAO);
                if (saveStatus != null) {
                    request.getSession().setAttribute("saveStatus", saveStatus);
                    PageUtil.redirectToPage(request, response, "StatusPage.html");
                }
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

                request.setAttribute("name", dep.getName());
                request.setAttribute("city", dep.getCity());
                request.setAttribute("errorValidate", validateError);
                request.setAttribute("pageType", "add");

                if (pageType.equals("edit")) {
                    request.setAttribute("pageType", "edit");
                    request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
                }
                PageUtil.forwardToPage(request, response, "editDepartment.jsp");

            }
            return validateError;
    }

    private String processDepartment(Department dep, HttpServletRequest request, HttpServletResponse response, String pageType, DepartmentDAO depDAO) throws IOException, ServletException {
        String saveStatus = null;

       /* if (pageType.equals("add")) {
            try {
                saveStatus = "Department created";
                depDAO.createDepartment(dep);
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
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
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return null;
            }

        }*/


        return saveStatus;
    }

}