package com.rom4.departments.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Employe;

import java.util.List;

/**
 * Created by rom4 on 17.07.14.
 * Creation time 18:15
 * Project name Departments
 */
public interface EmployeHibDAO {

    Employe createEmploye(Employe emp) throws AppException;
    Employe readEmploye(int EmployeID) throws AppException;
    Employe getEmployeByEmail(String email ) throws AppException;
    boolean udpateEmploye(Employe emp) throws AppException;
    boolean deleteEmploye(int EmployeID)throws AppException;
    List<Employe> getEmployes() throws AppException;
    List<Employe> getEmployes(int departmentID) throws AppException;
}
