package com.rom4.departments.validation;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ValidationFailedException;

import java.util.List;

/**
 * Created by rom4 on 28.07.14.
 * Creation time 17:53
 * Project name Departments
 */
public class DepartmentValidator implements Validator {
    @Override
    public List<ConstraintViolation> validate(Object validatedObject) throws IllegalArgumentException, ValidationFailedException {
        return super.validate(validatedObject);
    }
}
