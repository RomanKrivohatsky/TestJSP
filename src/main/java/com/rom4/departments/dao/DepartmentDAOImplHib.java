package com.rom4.departments.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.entity.Department;
import com.rom4.departments.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import sun.security.pkcs11.wrapper.Functions;

import java.util.List;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 12:32
 * Project name Departments
 */
public class DepartmentDAOImplHib implements  DepartmentHibDAO{

    @Override
    public Department getDepartmentByName(String name) throws AppException {
        Department department;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("name", name));
            department = (Department)cr.list().get(0);
            //Hibernate.initialize(department);
            Hibernate.initialize(department.getEmployes());
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public Integer createDepartment(Department dep) throws AppException {

        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(dep);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return dep.getDepartmentID();
    }

    @Override
    public Department readDepartment(Integer departmentID) throws AppException{

        Department department;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            department = (Department)session.load(Department.class, departmentID);
            //Hibernate.initialize(department);
            Hibernate.initialize(department.getEmployes());
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public boolean udpateDepartment(Department dep) throws AppException {

        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(dep);
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public boolean deleteDepartment(Integer departmentID) throws AppException {

        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(session.load(Department.class, departmentID));
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public List<Department> getDepartments() throws AppException {
        List<Department> departments = null;
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            departments = session.createQuery("from Department order by departmentID").list();
            tr.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
            throw new AppException("Hibernate exception:", e);
        }
        finally {
            if (session!=null) {
                session.close();
            }
        }

        return departments;
    }
}
