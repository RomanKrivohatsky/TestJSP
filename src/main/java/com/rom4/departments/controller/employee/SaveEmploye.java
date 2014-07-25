package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 19:58
 * Project name Departments
 */
public class SaveEmploye implements Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus;
        String validateError;
        String pageType;

        pageType = request.getParameter("pageType");

        Employee emp = parseEmployeFromRequest(request, response, pageType, depDAO);

        if (emp != null) {
            validateError = validateEmploye(request, response, emp, pageType, depDAO);
            //validate done
            if (validateError == null) {
                saveStatus =  processEmploye(emp, request , response, pageType, empDAO);
                if (saveStatus !=null) {
                    request.getSession().setAttribute("saveStatus", saveStatus);
                    PageUtil.redirectToPage(request, response, "StatusPage.html");
                }
                else {
                    request.setAttribute("saveStatus", "Can't determine type of saving page");
                    PageUtil.redirectToPage(request, response, "StatusPage.html");
                }

            }
        }
    }


    private Employee parseEmployeFromRequest(HttpServletRequest request, HttpServletResponse response, String pageType, DepartmentDAO  depDAO) throws IOException {

        Employee emp = new Employee();
        Department dep;
        try {

            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setEmail(request.getParameter("email"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            emp.setBirthday(sdf.parse(request.getParameter("birthday")));
            dep = depDAO.readDepartment(Integer.parseInt(request.getParameter("departmentID")));
            emp.setDepartment(dep);


            if (pageType.equals("edit")) {
                emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));
            }

        } catch (ParseException e) {
            e.printStackTrace();

        } catch (AppException e) {
            e.printStackTrace();
            PageUtil.redirectToErrorPage(request, response, e.getMessage());
        }

        return emp;
    }

    private String validateEmploye(HttpServletRequest request, HttpServletResponse response, Employee emp, String pageType, DepartmentDAO depDAO) throws ServletException, IOException {
        String validateError = null;

        Validator validator = new net.sf.oval.Validator();
        java.util.List violations = validator.validate(emp);

        if (!violations.isEmpty()) {
            validateError = ((ConstraintViolation) violations.get(0)).getMessage();

            List<Department> departments;
            try {
                departments = depDAO.getDepartments();
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return "error";
            }

            request.setAttribute("Departments", departments);
            request.setAttribute("errorValidate", validateError);
            request.setAttribute("firstName", emp.getFirstName());
            request.setAttribute("lastName", emp.getLastName());
            request.setAttribute("email", emp.getEmail());
            request.setAttribute("salary", emp.getSalary());
            request.setAttribute("birthday", emp.getBirthday());
            request.setAttribute("pageType", "add");

            if (pageType.equals("edit")) {
                request.setAttribute("pageType", "edit");
                request.setAttribute("employeID", Integer.parseInt(request.getParameter("employeID")));
                request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
            }
            PageUtil.forwardToPage(request, response, "editEmploye.jsp");

        }
        return validateError;
    }

    private String  processEmploye (Employee emp,  HttpServletRequest request, HttpServletResponse response, String pageType, EmployeDAO empDAO) throws IOException, ServletException {
        String saveStatus = null ;
        if (pageType.equals("add")) {
            try {
                saveStatus = "Employee created";
                empDAO.createEmploye(emp);
            }
            catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return null;
            }
        }
        else if (pageType.equals("edit")) {
            emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));

            try {
                saveStatus = "Employee updated";
                empDAO.udpateEmploye(emp);
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return null;
            }
        }
        return saveStatus;
    }


}
