package com.rom4.departments.validation;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeService;
import com.rom4.departments.service.impl.EmployeeDAOhibImpl;
import com.rom4.departments.service.impl.EmployeeServiceImpl;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rom4 on 10.07.14.
 * Creation time 12:13
 * Project name Departments
 */

public class EmailCheck extends AbstractAnnotationCheck<Email> {

    EmployeeService service = new EmployeeServiceImpl();

    @Override
    public boolean isSatisfied(Object validateObject, Object validateValue, OValContext oValContext, Validator validator) throws OValException {

    /*    service.setDao(new EmployeeDAOhibImpl());
        Employee employe = service.byEmail((String) validateValue);
        if (employe != null) {
            if (!employe.getEmployeID().equals(((Employee) validateObject).getEmployeID())) {
                return false;
            }
        }*/
        return true;
    }
}
