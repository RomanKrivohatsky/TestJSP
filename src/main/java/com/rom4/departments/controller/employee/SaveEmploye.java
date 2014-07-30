package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.Handler;
import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.EmployeeService;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
@Component("/SaveEmployee.html")
public class SaveEmploye implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String saveStatus;
        String pageType;

        if (request.getMethod().equals("GET")) {
            PageUtil.redirectToPage(request, response, "AddEmployee.html");
            return;
        }

        pageType = request.getParameter("pageType");

        Employee emp = parseEmployeFromRequest(request, pageType, departmentService);

        if (emp != null) {
            saveStatus = processEmploye(emp, request, response, pageType, departmentService, employeeService);
            if (saveStatus != null) {
                request.getSession().setAttribute("saveStatus", saveStatus);
                request.getSession().setAttribute("page", this.getClass().getName());

                PageUtil.redirectToPage(request, response, "AddEmployee.html");
            }
        }
    }

    private Employee parseEmployeFromRequest(HttpServletRequest request,
                                             String pageType, DepartmentService departmentService) throws IOException {

        Employee emp = new Employee();
        Department dep;
        try {
            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setEmail(request.getParameter("email"));
            if (request.getParameter("salary").equals("")) {
                emp.setSalary(0);
            }
            else {
                emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            }

            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            if (request.getParameter("birthday").equals("")) {
                emp.setBirthday(null);
            }
            else {
                emp.setBirthday(sdf.parse(request.getParameter("birthday")));
            }
            dep = departmentService.read(Integer.parseInt(request.getParameter("departmentID")));
            emp.setDepartment(dep);

            if (pageType.equals("edit")) {
                emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return emp;
    }

    private void validateEmploye(HttpServletRequest request, HttpServletResponse response, Employee emp,
                                 String pageType, DepartmentService departmentService, List<ObjectError> errors) throws ServletException, IOException {

        List<Department> departments;
        departments = departmentService.getList();

        for (ObjectError objectError : errors) {
            if (objectError instanceof FieldError) {
                request.setAttribute(((FieldError) objectError).getField() + "Error", objectError.getDefaultMessage());
            }
        }

        request.setAttribute("saveStatus", "");
        request.setAttribute("Departments", departments);
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

    private String processEmploye(Employee emp, HttpServletRequest request, HttpServletResponse response,
                                  String pageType, DepartmentService departmentService, EmployeeService employeeService) throws IOException, ServletException {
        String saveStatus = null;

            try {
                if (pageType.equals("add")) {
                    saveStatus = "Employee " + emp.getLastName() +" has been created";
                    employeeService.create(emp);
                }
                else if (pageType.equals("edit")) {
                    emp.setEmployeID(Integer.parseInt(request.getParameter("employeID")));
                    saveStatus =  "Employee " + emp.getLastName() +" has been updated";
                    employeeService.update(emp);
                }
            } catch (ValidateException e) {
                validateEmploye(request, response, emp, pageType, departmentService, e.getErrors());
                return null;
            }

        return saveStatus;
    }
}
