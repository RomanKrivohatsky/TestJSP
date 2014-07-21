package com.rom4.departments.dao;

/**
 * Created by rom4 on 02.07.14.
 */
public class DAOFactory {

    public static DepartmentDAO getDepartmentHibDAO () {
        return new DepartmentDAOImplHib();
    }


    public static DepartmentDAO getDepartmentDAO () {
        return new DepartmentDAOImpl();
    }


    public static EmployeDAO getEmployeDAO() {
        return new EmployeDAOImpl();
    }

    public static EmployeDAO getEmployeHibDAO() {
        return new EmployeDAOImplHib();
    }



}
