package com.rom4.departments.controller.employee;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rom4 on 04.08.14.
 */

public class DateEditor extends PropertyEditorSupport {

    public void setAsText(String value) {
        try {
            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        } catch(ParseException e) {
            setValue(null);
        }
    }

    public String getAsText() {
        String s = "";
        if (getValue() != null) {
            s = new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
        }
        return s;
    }
}