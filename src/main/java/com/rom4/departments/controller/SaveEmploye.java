package com.rom4.departments.controller;

import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Employe;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 19:58
 * Project name Departments
 */
public class SaveEmploye implements  Handler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO depDAO, EmployeDAO empDAO) throws IOException, ServletException {

        String saveStatus = "Error saving";
        String validateError;
        String pageType;

        pageType = request.getParameter("pageType");

        Employe emp = parseEmployeFromRequest(request, response, pageType);

        if (emp != null) {
            validateError = validateEmploye(request, response, emp, pageType);
            //validate done
            if (validateError == null) {
                 processEmploye(emp, request , response, pageType, empDAO);
                response.sendRedirect("SaveEmploye.jsp");
            }
        }
    }

    private Employe parseEmployeFromRequest(HttpServletRequest request, HttpServletResponse responce, String pageType) throws IOException {

        Employe emp = new Employe();

        try {
            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setEmail(request.getParameter("email"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            emp.setBirthday(sdf.parse(request.getParameter("birthday")));
            emp.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));

            if (pageType.equals("edit")) {
                emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));
            }

        } catch (ParseException e) {
            e.printStackTrace();
            /*redirectToErrorPage(request, responce, e.getMessage());
            return null;*/
        }

      return emp;
    }

    private String validateEmploye(HttpServletRequest request, HttpServletResponse response, Employe emp, String pageType) throws ServletException, IOException {
        String validateError = null;

        Validator validator = new net.sf.oval.Validator();
        java.util.List violations = validator.validate(emp);

        if (!violations.isEmpty()) {
            validateError = ((ConstraintViolation) violations.get(0)).getMessage();

            RequestDispatcher rd;

            request.setAttribute("errorValidate", validateError);
            request.setAttribute("firstName", emp.getFirstName());
            request.setAttribute("lastName", emp.getLastName());
            request.setAttribute("email", emp.getEmail());
            request.setAttribute("salary", emp.getSalary());
            request.setAttribute("birthday", emp.getBirthday());
            if (pageType.equals("add")) {
                rd = request.getRequestDispatcher("AddEmploye.jsp");
                rd.forward(request, response);
            } else if (pageType.equals("edit")) {
                request.setAttribute("employeID", Integer.parseInt(request.getParameter("employeID")));
                request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
                rd = request.getRequestDispatcher("EditEmploye.jsp");
                rd.forward(request, response);
            }
        }
        return validateError;
    }

    private void processEmploye (Employe emp,  HttpServletRequest request, HttpServletResponse response, String pageType, EmployeDAO empDAO)  throws IOException {
        String saveStatus;
        if (pageType.equals("add")) {
            try {
                saveStatus = "Employe created";
                emp = empDAO.createEmploye(emp);
            }
            catch (AppException a) {
                a.printStackTrace();
                saveStatus = a.getMessage();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return;
            }
        }
        else if (pageType.equals("edit")) {
            emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));

            try {
                saveStatus = "Employe updated";
                empDAO.udpateEmploye(emp);
            } catch (AppException a) {
                a.printStackTrace();
                PageUtil.redirectToErrorPage(request, response, a.getMessage());
                return;
            }
        }

    }


}
