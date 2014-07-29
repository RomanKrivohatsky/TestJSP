package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentDAOhib;
import com.rom4.departments.service.dao.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAOhib dao;

    @Override
    @Autowired
     public void setDao(DepartmentDAOhib dao) {
        this.dao = dao;
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
    public void create(Department dep) {
         dao.createDepartment(dep);
    }

    @Override
    @Transactional
    public void update(Department dep) {
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
