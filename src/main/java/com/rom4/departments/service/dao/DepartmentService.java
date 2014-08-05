package com.rom4.departments.service.dao;

import com.rom4.departments.domain.Department;
import com.rom4.departments.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rom4 on 28.07.14.
 * Creation time 18:13
 * Project name Departments
 */
public interface DepartmentService {

    @Transactional
    Department read(Integer departmentID);

    @Transactional
    Department byName(String name);

    @Transactional
    void create(Department dep) ;

    @Transactional
    void update(Department dep) ;

    @Transactional
    void delete(Department department);

    @Transactional
    List getList();
}
