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
public class EmployeDAOImplHib_old implements EmployeDAO {
    @Override
    public Integer createEmploye(Employe emp) throws AppException {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(emp);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return emp.getEmployeID();
    }

    @Override
    public Employe readEmploye(int EmployeID) throws AppException {
        Employe employe;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            employe = (Employe)session.load(Employe.class, EmployeID);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }
        return employe;
    }

    @Override
    public Employe getEmployeByEmail(String email) throws AppException {
        Employe employe;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("email", email));
            employe = (Employe)cr.list().get(0);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }
        return employe;
    }

    @Override
    public boolean deleteEmploye(int EmployeID) throws AppException {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(session.load(Employe.class, EmployeID));
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public boolean udpateEmploye(Employe emp) throws AppException {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(emp);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage() + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public List<Employe> getEmployes() throws AppException {
        List<Employe> employes = null;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            employes = session.createQuery("from Employe order by employeID").list();
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return employes;
    }

    @Override
    public List<Employe> getEmployes(int departmentID) throws AppException {
        List<Employe> employes = null;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Criteria cr = session.createCriteria(Employe.class);
            cr.add(Restrictions.eq("departmentID",departmentID ));
            employes = cr.list();
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:" + e.getMessage(), e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return employes;
    }
}
