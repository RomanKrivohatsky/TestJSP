package service.impl;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import static org.junit.Assert.*;


/**
 * Created by rom4 on 25.07.14.
 * Creation time 14:33
 * Project name Departments
 */
@ContextConfiguration (locations = "/WEB-INF/departments.xml")
public class DepartmentServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DepartmentServiceImpl service;

    @Test
    public void testRead() throws Exception {
        assertNotNull(service.read(1));
    }

    @Test
    public void testByName() throws Exception {
        assertNotNull(service.byName("it2"));
    }

    @Test
    public void testCreate() throws Exception {
   /*     Department department = new Department();
        department.setCity("Kharkov");
        department.setName("Git2");
        service.create(department);
        assertNotNull(service.byName("Git2"));*/
    }

    @Test
    public void testUpdate() throws Exception {
        Department department = service.byName("Git2");
        department.setCity("Kharkov3");
        service.update(department);
        assertEquals("Kharkov3", service.read(department.getDepartmentID()).getCity());
        assertEquals("Git2", service.read(department.getDepartmentID()).getName());
    }

    @Test
    public void testDelete() throws Exception {
   /*     Department department = service.byName("Git2");
        assertNotNull(department.getDepartmentID());
        service.delete(department);
        assertNotNull(service.byName("Git2"));
        assertNotNull(null);*/
    }

    public void testGetList() throws Exception {
        assertNotNull(service.getList());
    }


}
