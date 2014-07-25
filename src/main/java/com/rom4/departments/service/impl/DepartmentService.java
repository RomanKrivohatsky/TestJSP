package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentDAOhib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 11:07
 * Project name Departments
 */
@Service
@Transactional
public class DepartmentService {
    private DepartmentDAOhib dao;

    @Autowired
     public void setDao(DepartmentDAOhib dao) {
        this.dao = dao;
    }

    @Transactional
    public Department read(int departmentID) {
        return dao.readDepartment(departmentID);

    }

    @Transactional
    public Department byName(String name) {
        return dao.getDepartmentByName(name);
    }

    @Transactional
    public void create(Department dep) {
         dao.createDepartment(dep);
    }

    @Transactional
    public void update(Department dep) {
        dao.udpateDepartment(dep);
    }

    @Transactional
    public void delete(Department department) {
        dao.deleteDepartment(department);
    }

    @Transactional
    public List getList() {
        return dao.getDepartments();
    }


}
