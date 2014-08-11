package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 16:01
 * Project name Departments
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAOhib dao;

    @Autowired
    @Qualifier("employeeValidator")
    org.springframework.validation.Validator springValidator ;

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
    public void create(Employee employee) {
        dao.createEmployee(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
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
