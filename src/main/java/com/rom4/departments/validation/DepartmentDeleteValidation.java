package com.rom4.departments.validation;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by rom4 on 05.08.14.
 */
@Component
@Qualifier("departmentDeleteValidation")
public class DepartmentDeleteValidation implements Validator {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;


    @Override
    public void validate(Object target, Errors errors) {
        List<Employee> employes=  employeeService.getList(((Department)target).getDepartmentID());

        if (employes.size()>0) {
                errors.rejectValue("employees", "employees.exists", "Department has a employees!");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Department.class;
    }
}
