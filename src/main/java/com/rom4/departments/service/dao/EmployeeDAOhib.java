package com.rom4.departments.service.dao;

import com.rom4.departments.domain.Employee;

import java.util.List;

/**
 * Created by rom4 on 17.07.14.
 * Creation time 18:15
 * Project name Departments
 */
public interface EmployeeDAOhib {


    void createEmployee(Employee emp);
    Employee readEmployee(int EmployeID);
    Employee getEmployeeByEmail(String email );
    void udpateEmployee(Employee emp);
    void deleteEmployee(Employee emp);
    List<Employee> getEmployees();
    List<Employee> getEmployees(int departmentID);
}
