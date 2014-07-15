package com.rom4.departments.validation;

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.*;

/**
 * Created by rom4 on 14.07.14.
 * Creation time 14:08
 * Project name Departments
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = DepartmentName.class)

public @interface DepartmentNameUnique {

    String message() default "Department name is not unique";

}
