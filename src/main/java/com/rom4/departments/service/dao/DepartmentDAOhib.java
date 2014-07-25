package com.rom4.departments.service.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.domain.Department;

import java.util.List;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 11:23
 * Project name Departments
 */
public interface DepartmentDAOhib {
    Department getDepartmentByName(String name);
    void createDepartment(Department dep);
    Department readDepartment(Integer departmentID);
    void udpateDepartment(Department dep);
    void deleteDepartment(Integer departmentID);
    List<Department> getDepartments();
}
