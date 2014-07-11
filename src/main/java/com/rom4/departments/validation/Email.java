package com.rom4.departments.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.configuration.annotation.Constraint;

/**
 * Created by rom4 on 10.07.14.
 * Creation time 12:12
 * Project name Departments
 */
/**
 * This annotation validates e-mails.
 *

 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = EmailCheck.class)

public @interface Email {


    String message() default "email not unique";



    /**
     * error code passed to the ConstraintViolation object
     */
    String errorCode() default "error code - email not uniquel";


     /**
     * severity passed to the ConstraintViolation object
     */
    int severity() default 0;


    /**
     * The associated validation profiles.
     */
    String[] profiles() default {};

}
