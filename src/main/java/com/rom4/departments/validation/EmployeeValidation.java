package com.rom4.departments.validation;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by rom4 on 29.07.14.
 */

@Component
@Qualifier("employeeValidation")
public class EmployeeValidation implements Validator {

    @Autowired
    EmployeeService service;

    public void setService(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Employee employe = service.byEmail(((Employee) target).getEmail());
        if (employe != null) {
            if (!employe.getEmployeID().equals(((Employee) target).getEmployeID())) {
                errors.rejectValue("email", "email.duplicate", "duplicate email");
            }
        }
        if ( ((Employee)target).getSalary() < 0 ) {
            errors.rejectValue("salary", "salary.negative","Salary must be positive");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Employee.class;
    }
}
