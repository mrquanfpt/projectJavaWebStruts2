/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanntm.utils.DBUtils;

/**
 *
 * @author QuanNTM
 */
public class tblFeedbacksDAO implements Serializable{
    Connection conn;
    PreparedStatement stm;
    ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public boolean insertFeedback(String firstName, String lastName, String city, String subject) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert into tblFeedbacks (firstName, lastName, city, subject) values (?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, firstName);
                stm.setString(2, lastName);
                stm.setString(3, city);
                stm.setString(4, subject);
                int row = stm.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } finally {
            closeConnection();
        }
        return  result;
    }
}
