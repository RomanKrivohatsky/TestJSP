package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentDAOhib;
import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 11:07
 * Project name Departments
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAOhib dao;

    @Autowired
    @Qualifier("departmentValidation")
    org.springframework.validation.Validator springValidator ;

    public List<ObjectError> validate(Department department) {
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(department, "department");
        ValidationUtils.invokeValidator(springValidator, department, result);
        List<ObjectError> errors = result.getAllErrors();

        if(errors.size()>0) {
            return errors;
        }
        return null;
    }

    @Override
    @Transactional
    public Department read(int departmentID) {
        return dao.readDepartment(departmentID);
    }

    @Override
    @Transactional
    public Department byName(String name) {
        return dao.getDepartmentByName(name);
    }

    @Override
    @Transactional
    public void create(Department dep)  {
       /* List<ObjectError> errors = validate(dep);
        if ( errors != null) {
            throw new ValidateException("Employee validation error!", errors);
        }*/
         dao.createDepartment(dep);
    }

    @Override
    @Transactional
    public void update(Department dep) {
        /*List<ObjectError> errors = validate(dep);
        if ( errors != null) {
            throw new ValidateException("Employee validation error!", errors);
        }*/
        dao.udpateDepartment(dep);
    }

    @Override
    @Transactional
    public void delete(Department department) {
        dao.deleteDepartment(department);
    }

    @Override
    @Transactional
    public List getList() {
        return dao.getDepartments();
    }
}
