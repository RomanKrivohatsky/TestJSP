package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 15:51
 * Project name Departments
 */
@Repository
@Transactional
public class EmployeeDAOhibImpl implements EmployeeDAOhib {

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
    public void createEmployee(Employee emp) {
        currentSession().save(emp);
    }

    @Override
    @Transactional
    public Employee readEmployee(int EmployeID) {
        return (Employee) currentSession().get(Employee.class, EmployeID);
    }

    @Override
    @Transactional
    public Employee getEmployeeByEmail(String email) {
        Criteria cr = currentSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("email", email));
        if (cr.list().size()>0) {
            return (Employee)cr.list().get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employe) {
        currentSession().delete(employe);
    }

    @Override
    @Transactional
    public void udpateEmployee(Employee emp) {
        currentSession().merge(emp);
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return currentSession().createQuery("from Employee order by employeID").list();
    }

    @Override
    @Transactional
    public List<Employee> getEmployees(int departmentID) {
            /*Caused by: org.hibernate.QueryException: could not resolve property: department_id of: com.rom4.de
            partments.domain.Employee*/
            /*Criteria cr = currentSession().createCriteria(Employee.class);
            cr.add(Restrictions.eq("department_id", departmentID));*/
            SQLQuery query = currentSession().createSQLQuery("select * from employes where department_id = :department_id order by employe_id");
            query.addEntity(Employee.class);
            query.setParameter("department_id", departmentID);
            return query.list();
    }
}

