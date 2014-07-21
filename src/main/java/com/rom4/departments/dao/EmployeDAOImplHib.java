package com.rom4.departments.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;
import com.rom4.departments.model.Employe;
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
    public Integer createEmploye(Employe emp) throws AppException {
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
    public Employe readEmploye(int EmployeID) throws AppException {
        Employe employe;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            employe = (Employe)session.load(Employe.class, EmployeID);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employe;
    }

    @Override
    public Employe getEmployeByEmail(String email) throws AppException {
        Employe employe;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("email", email));
            employe = (Employe)cr.list().get(0);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employe;
    }

    @Override
    public boolean deleteEmploye(int EmployeID) throws AppException {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.delete(session.load(Employe.class, EmployeID));
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean udpateEmploye(Employe emp) throws AppException {
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.update(emp);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage() + e.getMessage(), e);
        }
        return true;
    }

    @Override
    public List<Employe> getEmployes() throws AppException {
        List<Employe> employes ;
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            employes = session.createQuery("from Employe order by employeID").list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }

        return employes;
    }

    @Override
    public List<Employe> getEmployes(int departmentID) throws AppException {
        List<Employe> employes ;
        Session session ;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Criteria cr = session.createCriteria(Employe.class);
            cr.add(Restrictions.eq("departmentID",departmentID ));
            employes = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        return employes;
    }
}
