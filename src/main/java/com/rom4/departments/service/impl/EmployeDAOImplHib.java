package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.EmployeDAO;
import com.rom4.departments.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by rom4 on 17.07.14.
 * Creation time 18:15
 * Project name Departments
 */
public class EmployeDAOImplHib implements EmployeDAO {
    @Override
    public Integer createEmploye(Employee emp) throws AppException {
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.save(emp);
           }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }

        return emp.getEmployeID();
    }

    @Override
    public Employee readEmploye(int EmployeID) throws AppException {
        Employee employee;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            employee = (Employee)session.get(Employee.class, EmployeID);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employee;
    }

    @Override
    public Employee getEmployeByEmail(String email) throws AppException {
        Employee employee;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("email", email));
            employee = (Employee)cr.list().get(0);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employee;
    }

    @Override
    public boolean deleteEmploye(int EmployeID) throws AppException {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.delete(session.load(Employee.class, EmployeID));
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean udpateEmploye(Employee emp) throws AppException {
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.update(emp);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage() + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public List<Employee> getEmployes() throws AppException {
        List<Employee> employees;
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            employees = session.createQuery("from Employee order by employeID").list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployes(int departmentID) throws AppException {
        List<Employee> employees;
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("departmentID",departmentID ));
            employees = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employees;
    }
}
