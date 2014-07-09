package com.rom4.departments.dao;

import com.rom4.departments.connection.ConnectionInstance;
import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rom4 on 02.07.14.
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public Department createDepartment(Department dep) throws AppExcepption {

        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            dep = null;
            return dep;
        }

        try {

            ps = conn.prepareStatement("insert departments (name, city) values (?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
            //ps = conn.prepareStatement("insert departments (name, city) values (?,?)");
            ps.setString(1, dep.getName());
            ps.setString(2, dep.getCity());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                dep.setDepartmentID(rs.getInt(1));
            }

        } catch (SQLException e) {
            dep = null;
            e.printStackTrace();
            throw new AppExcepption("Can't create new department /n" + e.getMessage(), e);
        } finally {
            closeConnection(rs, ps, conn);
        }

        return dep;

    }

    @Override
    public Department readDepartment(Integer departmentID) throws AppExcepption {
        Department dep = null;
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return dep;
        }

        try {
            ps = conn.prepareStatement("select department_id, name, city from departments where department_id = ?");
            ps.setInt(1, departmentID);

            rs = ps.executeQuery();

            if (rs.next()) {
                dep = new Department();
                dep.setDepartmentID(departmentID);
                dep.setName(rs.getString(2));
                dep.setCity(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw  new AppExcepption("Can't read department from DB /n" + e.getMessage(), e);
        } finally {
            closeConnection(rs, ps, conn);
        }

        return dep;
    }

    @Override
    public boolean udpateDepartment(Department dep) throws AppExcepption {

        Connection conn;
        PreparedStatement ps = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return false;
        }

        try {

            ps = conn.prepareStatement("update departments set name = ?, city = ? where department_id = ?");
            ps.setString(1, dep.getName());
            ps.setString(2, dep.getCity());
            ps.setInt(3, dep.getDepartmentID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw  new AppExcepption("Can't update department /n" + e.getMessage(), e);
        } finally {
            closeConnection( ps, conn);

        }


        return true;
    }

    @Override
    public boolean deleteDepartment(Integer departmentID) throws AppExcepption {

        Connection conn;
        PreparedStatement ps = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return false;
        }

        try {

            ps = conn.prepareStatement("delete from departments where department_id = ?");
            ps.setInt(1, departmentID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new AppExcepption("Can't delete department /n" + e.getMessage(), e);
        } finally {
            closeConnection(ps, conn);
        }

        return true;
    }

    @Override
    public List<Department> getDepartments() throws AppExcepption {

        Connection conn ;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Department> departments = new ArrayList<Department>();;
        Department dep;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return departments;
        }

        try {
            ps = conn.prepareStatement("select department_id, name, city from departments order by department_id");
            rs = ps.executeQuery();

            while (rs.next()) {
                dep = new Department();
                dep.setDepartmentID(rs.getInt(1));
                dep.setName(rs.getString(2));
                dep.setCity(rs.getString(3));
                departments.add(dep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new AppExcepption("Can't read departments /n" + e.getMessage(), e);

        } finally {
            closeConnection(rs, ps, conn);
        }
        return departments;
    }

    private void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws AppExcepption {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new AppExcepption("Can't close connection /n" + e.getMessage(), e);
            }
    }

    private void closeConnection(PreparedStatement ps, Connection conn) throws AppExcepption {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AppExcepption("Can't close connection /n" + e.getMessage(), e);
        }
    }

}
