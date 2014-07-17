package com.rom4.departments.dao;


import com.rom4.departments.entity.Department;
import com.rom4.departments.entity.Employe;
import junit.framework.TestCase;

import java.util.Collection;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 13:54
 * Project name Departments
 */
public class DepartmentDAOImplHibTest extends TestCase {

    public void testCreateDepartment() throws Exception {

 /*       DepartmentDAO dao = DAOFactory.getDepartmentHibDAO();
        Department dep = new Department();
        dep.setCity("Gori2");
        dep.setName("xxxx123456789");
        dep.setDepartmentID(dao.createDepartment(dep));

        System.out.println(dep);

        Department depNew;
        depNew = dao.readDepartment(dep.getDepartmentID());

        //System.out.println(dep.getEmployes());
       // System.out.println(depNew);
        assertEquals(dep, depNew);*/
    }

    public void testReadDepartment() throws Exception {

        DepartmentHibDAO dao = DAOFactory.getDepartmentHibDAO();
       // Department dep = new Department();
     /*   dep.setCity("moscow");
        dep.setName("it50022");
        dep.setDepartmentID(dao.createDepartment(dep));
*/
        Department depNew;
        depNew = dao.readDepartment(1);
        //Hibernate.initialize(depNew.getEmployes());

        System.out.println(depNew.getName());
    /*    Collection<Employe> emp = depNew.getEmployes();
        for (Employe e:emp) {
            System.out.println(e);
        }*/
    }

/*
    public void testDeleteDepartment() throws Exception {

        DepartmentDAO dao = DAOFactory.getDepartmentHibDAO();
        Department dep = new Department();
        dep.setCity("moscow2");
        dep.setName("it500122");
        dao.deleteDepartment(dep.getDepartmentID());

        Department depNew;
        depNew = dao.readDepartment(dep.getDepartmentID());

        assertEquals(null, depNew);

    }

    public void testGetDepartments() throws Exception {
        List<Department> deps;
        DepartmentDAO dao = DAOFactory.getDepartmentHibDAO();
        deps = dao.getDepartments();
        for (Department department: deps) {
            System.out.println(department);
        }

    }*/

}
