package com.rom4.departments.dao;

import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Department;

import java.util.List;

/**
 * Created by rom4 on 02.07.14.
 */
public interface DepartmentDAO {
    Department createDepartment(Department dep) throws AppExcepption;
    Department readDepartment(Integer departmentID) throws AppExcepption;
    boolean udpateDepartment(Department dep) throws AppExcepption;
    boolean deleteDepartment(Integer departmentID)throws AppExcepption;
    List<Department> getDepartments() throws AppExcepption;

}
