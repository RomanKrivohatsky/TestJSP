package com.rom4.departments.validation;

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
    private EmployeeService service;

    public void setService(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void validate(Object target, Errors errors) {

        if ( ((Employee)target).getEmail().equals("") || ((Employee)target).getEmail() == null ) {
            errors.rejectValue("email", "email.empty","Email must be not empty");
        }

        if ( ((Employee)target).getFirstName().equals("") || ((Employee)target).getFirstName() == null ) {
            errors.rejectValue("firstName", "firstName.empty","First name must be not empty");
        }

        if ( ((Employee)target).getLastName().equals("") || ((Employee)target).getLastName() == null ) {
            errors.rejectValue("lastName", "lastName.empty","Last name must be not empty");
        }

        if ( ((Employee)target).getSalary() < 1 ) {
            errors.rejectValue("salary", "salary.negative","Salary must be positive and more than 0");
        }
        if ( ((Employee)target).getBirthday() == null ) {
            errors.rejectValue("birthday", "birthday.birthday.null","Birthday must be not empty");
        }

        Employee employe = service.byEmail(((Employee) target).getEmail());

        if (employe != null) {
            if (!employe.getEmployeeID().equals(((Employee) target).getEmployeeID())) {
                errors.rejectValue("email", "email.duplicate", "duplicate email");
            }
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Employee.class;
    }
}
