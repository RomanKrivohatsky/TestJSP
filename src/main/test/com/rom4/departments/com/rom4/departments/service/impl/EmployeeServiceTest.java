package com.rom4.departments.service.impl;

import com.rom4.departments.domain.Employee;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by rom4 on 25.07.14.
 * Creation time 16:11
 * Project name Departments
 */
@ContextConfiguration(locations = "/departments.xml")

public class EmployeeServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private EmployeeService service;

    @Autowired
    private DepartmentService serviceDepartment;

    @Test
    public void testRead() throws Exception {
        assertNotNull(service.read(2));
    }
    @Test
    public void testByEmail() throws Exception {
        assertNotNull(service.byEmail("dfisdf@sdfsdf"));
    }
    @Test
    public void testCreate() throws Exception {

  /*      Employee employee = new Employee();
        employee.setLastName("Bubka12345");
        employee.setFirstName("Sergey12345");
        employee.setEmail("Bubka12345@mail.ru");
        employee.setDepartment(serviceDepartment.read(1));
        employee.setSalary(123.1F);
        employee.setBirthday(new Date());
        service.create(employee);
        assertNotNull(service.byEmail("Bubka12345@mail.ru"));
        assertEquals("Bubka12345@mail.ru", service.byEmail("Bubka12345@mail.ru").getEmail());*/
    }
    @Test
    public void testUpdate() throws Exception {
        Employee employee = service.read(26);
        employee.setLastName("Einshtein");
        service.update(employee);
        assertEquals("Einshtein", service.read(26).getLastName());

    }
    @Test
    public void testDelete() throws Exception {
        //assertNotNull(service.read(39));
        Employee employee = service.read(35);
        service.delete(employee);
        assertNull(service.read(35));
    }
    @Test
    public void testGetList() throws Exception {
        assertNotNull(service.getList());
    }
}
