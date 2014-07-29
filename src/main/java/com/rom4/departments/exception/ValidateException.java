package com.rom4.departments.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by rom4 on 29.07.14.
 */
public class ValidateException extends Exception{

    private List<ObjectError> errors;

    public ValidateException() {
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(String message, List<ObjectError> errors) {
        super(message);
        this.setErrors(errors);
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

}
