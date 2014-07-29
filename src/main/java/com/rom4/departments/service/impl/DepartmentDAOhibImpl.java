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
public class DepartmentDAOhibImpl implements DepartmentDAOhib {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Department getDepartmentByName(String name) {
        Criteria cr = currentSession().createCriteria(Department.class);
        cr.add(Restrictions.eq("name", name));
        if (cr.list().size()>0) {
            return (Department) cr.list().get(0);
        }
        return null;
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
    public void deleteDepartment(Department department) {
        currentSession().delete(department);
    }

    @Override
    @Transactional
    public List<Department> getDepartments() {
        return currentSession().createQuery("from Department order by departmentID").list();
    }



}
