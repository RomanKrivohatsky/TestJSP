package com.rom4.departments.service.dao;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 18:21
 * Project name Departments
 */
public interface EmployeeService {
    @Autowired
    void setDao(EmployeeDAOhib dao);

    @Transactional
    Employee read(int EmployeeID);

    @Transactional
    Employee byEmail(String email);

    @Transactional
    void create(Employee dep);

    @Transactional
    void update(Employee dep);

    @Transactional
    void delete(Employee Employee);

    @Transactional
    List getList();

    @Transactional
    List getList(int departmentID);
}
