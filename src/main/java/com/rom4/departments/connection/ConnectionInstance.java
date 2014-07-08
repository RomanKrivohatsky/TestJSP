package com.rom4.departments.connection;

import com.rom4.departments.properties.PropertiesService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by rom4 on 02.07.14.
 * Singleton, that create a conection
 */

public class ConnectionInstance {

     //private constructor
    private ConnectionInstance() {
    }

    public static Connection getConnection () {

        Connection conn = null;
        String url;
        String user;
        String pass;

        try {
                Class.forName("com.mysql.jdbc.Driver");

                PropertiesService ps = PropertiesService.getService();
                url = ps.getParam("url");
                user = ps.getParam("user");
                pass = ps.getParam("password");

                try {
                    conn = DriverManager.getConnection(url,user, pass );
                    System.out.println("connected");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        return conn;
    }

}
