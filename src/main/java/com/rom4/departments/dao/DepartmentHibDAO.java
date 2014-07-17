package com.rom4.departments.dao;

import com.rom4.departments.entity.Department;
import com.rom4.departments.exception.AppException;

import java.util.List;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 19:08
 * Project name Departments
 */
public interface DepartmentHibDAO {
    Department getDepartmentByName(String name) throws AppException;
    Integer createDepartment(Department dep) throws AppException;
    Department readDepartment(Integer departmentID) throws AppException;
    boolean udpateDepartment(Department dep) throws AppException;
    boolean deleteDepartment(Integer departmentID)throws AppException;
    List<Department> getDepartments() throws AppException;
}
