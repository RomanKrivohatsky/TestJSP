package com.rom4.departments.controller.employee;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by rom4 on 29.07.14.
 */
public class EmployeeUtils {


    public Employee parseEmployeFromRequest(HttpServletRequest request, HttpServletResponse response,
                                             String pageType, DepartmentService departmentService) throws IOException {

        Employee emp = new Employee();
        Department dep;
        try {
            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setEmail(request.getParameter("email"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            emp.setBirthday(sdf.parse(request.getParameter("birthday")));
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
}
