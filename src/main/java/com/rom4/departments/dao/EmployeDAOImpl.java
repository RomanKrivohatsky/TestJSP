package com.rom4.departments.dao;

import com.rom4.departments.connection.ConnectionInstance;
import com.rom4.departments.exception.AppExcepption;
import com.rom4.departments.model.Employe;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rom4 on 07.07.14.
 * Creation time 16:39
 * Project name Employes
 */
public class EmployeDAOImpl implements EmployeDAO  {
    @Override
    public Employe createEmploye(Employe emp) throws AppExcepption {


        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            emp = null;
            return emp;
        }

        try {


            ps = conn.prepareStatement("insert employes \n" +
                    "(first_name," +
                    "last_name, " +
                    "email, " +
                    "salary, " +
                    "birthday," +
                    "department_id) " +
                    "values (?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setFloat(4, emp.getSalary());

            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

            ps.setString(5, sdf.format(emp.getBirthday()));
            ps.setInt(6, emp.getDepartmentID());


            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                emp.setEmployeID(rs.getInt(1));
            }

        } catch (SQLException e) {
            emp = null;
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't create new employe /n" + e.getMessage(), e);
            throw exception;
        } finally {
            closeConnection(rs, ps, conn);
        }

        return emp;
    }

    @Override
    public Employe readEmploye(int EmployeID) throws AppExcepption {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employe emp = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return emp;
        }

        try {
            ps = conn.prepareStatement("select first_name,last_name, email, salary, birthday,department_id from employes where employe_id = ?");
            ps.setInt(1, EmployeID);
            rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employe();
                try {
                    emp.setFirstName(rs.getString(1));
                    emp.setLastName(rs.getString(2));
                    emp.setEmail(rs.getString(3));
                    emp.setSalary(rs.getFloat(4));
                    DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    emp.setBirthday(sdf.parse(rs.getString(5)));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't read employe /n" + e.getMessage(), e);
            throw exception;
        } finally {
            closeConnection(rs, ps, conn);
        }
        return emp;
    }

    @Override
    public boolean udpateEmploye(Employe emp) throws AppExcepption {

        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return false;
        }

        try {

            ps = conn.prepareStatement("update employes set \n" +
                    " first_name = ?," +
                    "last_name = ?, " +
                    "email = ?, " +
                    "salary = ?, " +
                    "birthday = ?," +
                    "department_id = ?) " +
                    "values (?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setFloat(4, emp.getSalary());
            DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            ps.setString(5, sdf.format(emp.getBirthday()));
            ps.setInt(6, emp.getDepartmentID());
            ps.executeUpdate();

            if (rs.next()) {
                emp.setEmployeID(rs.getInt(1));
            }

        } catch (SQLException e) {
            emp = null;
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't update employe /n" + e.getMessage(), e);
            throw exception;
        } finally {
            closeConnection(rs, ps, conn);
        }

        return true;
    }

    @Override
    public boolean deleteEmploye(int EmployeID) throws AppExcepption {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return false;
        }

        try {
            ps = conn.prepareStatement("delete from employes where employe_id = ?");
            ps.setInt(1, EmployeID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't delete employe /n" + e.getMessage(), e);
            throw exception;
        }
        finally {
            closeConnection(rs, ps, conn);
        }

        return true;
    }

    @Override
    public List<Employe> getEmployes() throws AppExcepption {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Employe> Employes = new ArrayList<>();;
        Employe emp;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return Employes;
        }

        try {
            ps = conn.prepareStatement("select first_name,last_name, email, salary, birthday,department_id, employe_id from employes order by employe_id");
            rs = ps.executeQuery();

            while (rs.next()) {
                emp = new Employe();
                try {
                    emp.setFirstName(rs.getString(1));
                    emp.setLastName(rs.getString(2));
                    emp.setEmail(rs.getString(3));
                    emp.setSalary(rs.getFloat(4));
                    DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    emp.setBirthday(sdf.parse(rs.getString(5)));
                    emp.setEmployeID(rs.getInt(6));
                    emp.setEmployeID(rs.getInt(7));
                    Employes.add(emp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't read an employes /n" + e.getMessage(), e);
            throw exception;
        } finally {
            closeConnection(rs, ps, conn);
        }
        return Employes;
    }

    @Override
    public List<Employe> getEmployes(int departmentID) throws AppExcepption {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Employe> Employes = new ArrayList<>();;
        Employe emp;

        conn = ConnectionInstance.getConnection();

        if (conn == null) {
            return Employes;
        }

        try {
            ps = conn.prepareStatement("select first_name,last_name, email, salary, birthday,department_id, employe_id " +
                                        "from employes where department_id =? order by employe_id");
            ps.setInt(1, departmentID);
            rs = ps.executeQuery();

            while (rs.next()) {
                emp = new Employe();
                try {
                    emp.setFirstName(rs.getString(1));
                    emp.setLastName(rs.getString(2));
                    emp.setEmail(rs.getString(3));
                    emp.setSalary(rs.getFloat(4));
                    DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    emp.setBirthday(sdf.parse(rs.getString(5)));
                    emp.setEmployeID(rs.getInt(6));
                    emp.setEmployeID(rs.getInt(7));
                    Employes.add(emp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            AppExcepption exception = new AppExcepption("Can't read an employes by id /n" + e.getMessage(), e);
            throw exception;
        } finally {
            closeConnection(rs, ps, conn);
        }
        return Employes;
    }

    private void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws AppExcepption {
        if (rs != null) {
            try {
                rs.close();
                if (rs != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                AppExcepption exception = new AppExcepption("Can't close connection /n" + e.getMessage(), e);
                throw exception;
            }

        }
    }

    public static void main(String Args[]) {
        EmployeDAOImpl dao = new EmployeDAOImpl();
        Employe e = new Employe();
        e.setFirstName("igor2");
        e.setLastName("Fagot2");
        e.setEmail("aa11.@mmm.com");
        e.setSalary(123.123F);

        //        String dd = SimpleDateFormat.getInstance().format(new Date());
        e.setBirthday(new Date());
        e.setEmployeID(1);

       /* dao.createEmploye(e);

        List<Employe> emps = dao.getEmployes();

        for (Employe em:emps) {
            System.err.println(em);
        }

        System.err.println("dep_id = 1");
         emps = dao.getEmployes(2);

        for (Employe em:emps) {
            System.err.println(em);
        }*/

    }
}

