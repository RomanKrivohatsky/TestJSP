package com.rom4.departments.service.impl;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentDAO;
import com.rom4.departments.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 12:32
 * Project name Departments
 */
public class DepartmentDAOImplHib implements DepartmentDAO {

    @Override
    public Department getDepartmentByName(String name) throws AppException {
        Department department;
        try {
            Session session;
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("name", name));
            department = (Department)cr.list().get(0);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return department;
    }

    @Override
    public Integer createDepartment(Department dep) throws AppException {

        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.save(dep);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }

        return dep.getDepartmentID();
    }

    @Override
    public Department readDepartment(Integer departmentID) throws AppException{

        Department department;
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            department = (Department)session.load(Department.class, departmentID);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return department;
    }

    @Override
    public boolean udpateDepartment(Department dep) throws AppException {

        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.update(dep);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage() + e.getMessage(), e);
        }

        return true;
    }

    @Override
    public boolean deleteDepartment(Integer departmentID) throws AppException {

        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.delete(session.load(Department.class, departmentID));
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public List<Department> getDepartments() throws AppException {
        List<Department> departments;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            departments = session.createQuery("from Department order by departmentID").list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }

        return departments;
    }
}