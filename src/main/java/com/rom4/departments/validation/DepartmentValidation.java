package com.rom4.departments.validation;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by rom4 on 29.07.14.
 */
@Component
@Qualifier("departmentValidation")
public class DepartmentValidation implements Validator {

    @Autowired
    DepartmentService service;

    public void setService(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Department department = service.byName(((Department) target).getName());
        if (department != null) {
            if (!department.getDepartmentID().equals(((Department) target).getDepartmentID())) {
                errors.rejectValue("name", "name.duplicate", "duplicate department name");
            }
        }

        if ( ((Department)target).getName().equals("") || ((Department)target).getName() == null ) {
            errors.rejectValue("nameEmpty", "name.empty","Department name must be not empty");
        }
        if ( ((Department)target).getCity().equals("") || ((Department)target).getCity() == null ) {
            errors.rejectValue("city", "city.empty","City name must be not empty");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Department.class;
    }
}
