package com.rom4.departments.exception;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 13:13
 * Project name Departments
 */
public class AppException extends  Exception {
    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
