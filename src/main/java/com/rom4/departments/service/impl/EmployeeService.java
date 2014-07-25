package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeDAOhib;
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
public class EmployeeService {
    private EmployeeDAOhib dao;

    @Autowired
    public void setDao(EmployeeDAOhib dao) {
        this.dao = dao;
    }

    @Transactional
    public Employee read(int EmployeeID) {
        return dao.readEmployee(EmployeeID);
    }

    @Transactional
    public Employee byEmail(String email) {
        return dao.getEmployeeByEmail(email);
    }

    @Transactional
    public void create(Employee dep) {
        dao.createEmployee(dep);
    }

    @Transactional
    public void update(Employee dep) {
        dao.udpateEmployee(dep);
    }

    @Transactional
    public void delete(Employee Employee) {
        dao.deleteEmployee(Employee);
    }

    @Transactional
    public List getList() {
        return dao.getEmployees();
    }


}
