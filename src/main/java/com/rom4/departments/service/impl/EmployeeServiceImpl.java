package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeeDAOhib dao;

    @Override
    @Autowired
    public void setDao(EmployeeDAOhib dao) {
        this.dao = dao;
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
    public void create(Employee dep) {
        dao.createEmployee(dep);
    }

    @Override
    @Transactional
    public void update(Employee dep) {
        dao.udpateEmployee(dep);
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
