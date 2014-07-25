package com.rom4.departments.service.dao;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.AppException;

import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:37
 * Project name Employes
 */
public interface EmployeDAO {
    Integer createEmploye(Employee emp) throws AppException;
    Employee readEmploye(int EmployeID) throws AppException;
    Employee getEmployeByEmail(String email ) throws AppException;
    boolean udpateEmploye(Employee emp) throws AppException;
    boolean deleteEmploye(int EmployeID)throws AppException;
    List<Employee> getEmployes() throws AppException;
    List<Employee> getEmployes(int departmentID) throws AppException;

}
