package com.rom4.departments.controller.employee.editors;

import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * Created by rom4 on 04.08.14.
 */

public class EmployeeEditor extends PropertyEditorSupport{

    private DepartmentService service;

    public EmployeeEditor(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        this.setValue(service.read(Integer.parseInt(text)));
    }
}
