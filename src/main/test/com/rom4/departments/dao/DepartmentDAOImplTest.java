package dao;

import com.rom4.departments.dao.DAOFactory;
import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.DepartmentDAOImpl;
import com.rom4.departments.model.Department;
import junit.framework.TestCase;

/**
 * Created by rom4 on 15.07.14.
 * Creation time 20:24
 * Project name Departments
 */
public class DepartmentDAOImplTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testCreateDepartment() throws Exception {

    }

    public void testReadDepartment() throws Exception {
        DepartmentDAO dao = DAOFactory.getDepartmentDAO();
        Integer id;
        Department d = new Department();
        d.setCity("texas234");
        d.setName("ibm234");
        id = dao.createDepartment(d);
        d.setDepartmentID(id);
        Department dNew;
        dNew = dao.readDepartment(d.getDepartmentID());

        System.out.println(dNew);

        assertEquals(d, dNew);

    }
}
