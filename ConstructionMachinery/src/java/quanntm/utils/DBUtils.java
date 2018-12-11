/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author QuanNTM
 */
public class DBUtils{
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ConstructionMachinery;instanceName=SQLEXPRESS";
            conn = DriverManager.getConnection(url, "sa", "120998");
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return conn;
    }
}
