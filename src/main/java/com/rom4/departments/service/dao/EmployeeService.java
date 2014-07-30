package com.rom4.departments.service.dao;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 18:21
 * Project name Departments
 */
public interface EmployeeService {

    @Transactional
    Employee read(int EmployeeID);

    @Transactional
    Employee byEmail(String email);

    @Transactional
    void create(Employee dep) throws ValidateException;

    @Transactional
    void update(Employee dep) throws ValidateException;

    @Transactional
    void delete(Employee Employee);

    @Transactional
    List getList();

    @Transactional
    List getList(int departmentID);
}
