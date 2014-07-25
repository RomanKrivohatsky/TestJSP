package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.EmployeeDAOhib;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public void createEmploye(Employee emp) {
        currentSession().save(emp);
    }

    @Override
    public Employee readEmploye(int EmployeID) {
        return (Employee) currentSession().get(Employee.class, EmployeID);
    }

    @Override
    public Employee getEmployeByEmail(String email) {
        Criteria cr = currentSession().createCriteria(Department.class);
        cr.add(Restrictions.eq("email", email));
        return (Employee) cr.list().get(0);
    }

    @Override
    public void deleteEmploye(Employee employe) {
        currentSession().delete(employe);
    }

    @Override
    public void udpateEmploye(Employee emp) {
        currentSession().update(emp);
    }

    @Override
    public List<Employee> getEmployes() {
        return currentSession().createQuery("from Employee order by employeID").list();
    }

    @Override
    public List<Employee> getEmployes(int departmentID) {
            Criteria cr = currentSession().createCriteria(Employee.class);
            cr.add(Restrictions.eq("departmentID", departmentID));
            return cr.list();
    }
}

