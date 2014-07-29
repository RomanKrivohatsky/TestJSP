package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 16:01
 * Project name Departments
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAOhib dao;

    @Override
    @Autowired
    public void setDao(EmployeeDAOhib dao) {
        this.dao = dao;
    }

    @Autowired
    @Qualifier("employeeValidation")
    org.springframework.validation.Validator springValidator ;

    public void setValidator(Validator springValidator) {
        this.springValidator = springValidator;
    }

    public List<ObjectError> validate(Employee employee) {
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(employee, "employee");
        ValidationUtils.invokeValidator(springValidator, employee, result);
        List<ObjectError> errors = result.getAllErrors();

        if(errors.size()>0) {
            return errors;
        }
        return null;
    }

    @Override
    @Transactional
    public Employee read(int EmployeeID) {
        return dao.readEmployee(EmployeeID);
    }

    @Override
    @Transactional
    public Employee byEmail(String email) {
        return dao.getEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public void create(Employee employee)  throws ValidateException {
        List<ObjectError> errors = validate(employee);

        if ( errors != null) {
            throw new ValidateException("Employee validation error!", errors);
        }
        dao.createEmployee(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) throws ValidateException {
        List<ObjectError> errors = validate(employee);
        if ( errors.size()>0) {
            throw new ValidateException("Employee validation error!", errors);
        }
        dao.udpateEmployee(employee);
    }

    @Override
    @Transactional
    public void delete(Employee Employee) {
        dao.deleteEmployee(Employee);
    }

    @Override
    @Transactional
    public List getList() {
        return dao.getEmployees();
    }

    @Override
    @Transactional
    public List getList(int departmentID) {
        return dao.getEmployees(departmentID);
    }

}
