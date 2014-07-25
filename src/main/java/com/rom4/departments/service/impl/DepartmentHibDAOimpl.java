package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentDAOhib;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 12:32
 * Project name Departments
 */

@Repository
@Transactional
public class DepartmentHibDAOimpl implements DepartmentDAOhib {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DepartmentHibDAOimpl() {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Department getDepartmentByName(String name) {
        Department department;
        Criteria cr = currentSession().createCriteria(Department.class);
        cr.add(Restrictions.eq("name", name));
        department = (Department) cr.list().get(0);
        return department;
    }

    @Override
    @Transactional
    public void createDepartment(Department dep) {
        currentSession().save(dep);
    }

    @Override
    @Transactional
    public Department readDepartment(Integer departmentID) {
        return (Department) currentSession().get(Department.class, departmentID);
    }

    @Override
    @Transactional
    public void udpateDepartment(Department dep) {
        currentSession().update(dep);
    }

    @Override
    @Transactional
    public void deleteDepartment(Integer departmentID) {
        currentSession().delete(currentSession().load(Department.class, departmentID));

    }

    @Override
    @Transactional
    public List<Department> getDepartments() {
        return currentSession().createQuery("from Department order by departmentID").list();
    }



}