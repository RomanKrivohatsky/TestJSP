package com.rom4.departments.dao;

import com.rom4.departments.model.Department;

import java.util.List;

/**
 * Created by rom4 on 02.07.14.
 */
public class DAOFactory {

    public static DepartmentHibDAO getDepartmentHibDAO () {
        return new DepartmentDAOImplHib();
    }


    public static DepartmentDAO getDepartmentDAO () {
        return new DepartmentDAOImpl();
    }


    public static EmployeDAO getEmployeDAO() {
        return new EmployeDAOImpl();
    }


    public static void main(String args[]) {
        DepartmentDAO dao = DAOFactory.getDepartmentDAO();

        /*Department dep = dao.readDepartment(1);

        //if (dep !=null) System.out.println(dep);

        List<Department> deps = dao.getDepartments();

        for (Department d:deps) {
            System.out.println(d);
        }

        dep.setName("it6");
        dep.setCity("Donetsk");

        dep = dao.createDepartment(dep);

        if (dep != null) {
            System.out.println(dep);
        }*/
    }


}
