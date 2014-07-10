package com.rom4.departments.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;

import java.util.List;

/**
 * Created by rom4 on 02.07.14.
 */
public interface DepartmentDAO {
    Department createDepartment(Department dep) throws AppException;
    Department readDepartment(Integer departmentID) throws AppException;
    boolean udpateDepartment(Department dep) throws AppException;
    boolean deleteDepartment(Integer departmentID)throws AppException;
    List<Department> getDepartments() throws AppException;

}
