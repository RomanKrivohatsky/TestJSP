package com.rom4.departments.dao;

import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Employe;

import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:37
 * Project name Employes
 */
public interface EmployeDAO {
    Employe createEmploye(Employe emp) throws AppExcepption;
    Employe readEmploye(int EmployeID) throws AppExcepption;
    boolean udpateEmploye(Employe emp) throws AppExcepption;
    boolean deleteEmploye(int EmployeID)throws AppExcepption;
    List<Employe> getEmployes() throws AppExcepption;
    List<Employe> getEmployes(int departmentID) throws AppExcepption;
}
