package com.rom4.departments.dao;

import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;

import java.util.List;

/**
 * Created by rom4 on 16.07.14.
 * Creation time 12:32
 * Project name Departments
 */
public class DepartmentDAOImplHib implements  DepartmentDAO{

    @Override
    public Department getDepartmentByName(String name) throws AppException {
        return null;
    }

    @Override
    public Department createDepartment(Department dep) throws AppException {
        return null;
    }

    @Override
    public Department readDepartment(Integer departmentID) throws AppException {
        return null;
    }

    @Override
    public boolean udpateDepartment(Department dep) throws AppException {
        return false;
    }

    @Override
    public boolean deleteDepartment(Integer departmentID) throws AppException {
        return false;
    }

    @Override
    public List<Department> getDepartments() throws AppException {
        return null;
    }
}
