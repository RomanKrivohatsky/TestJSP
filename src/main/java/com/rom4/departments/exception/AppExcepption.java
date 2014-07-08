package com.rom4.departments.exception;

/**
 * Created by rom4 on 08.07.14.
 * Creation time 13:13
 * Project name Departments
 */
public class AppExcepption extends  Exception {
    public AppExcepption() {
    }

    public AppExcepption(String message) {
        super(message);
    }

    public AppExcepption(String message, Throwable cause) {
        super(message, cause);
    }
}
