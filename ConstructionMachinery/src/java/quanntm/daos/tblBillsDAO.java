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
import java.sql.Timestamp;
import java.util.Calendar;
import quanntm.utils.DBUtils;

/**
 *
 * @author QuanNTM
 */
public class tblBillsDAO implements Serializable{
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
    
    public boolean insertBill(String username, String idMachines, int quantity, double price)
            throws Exception {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert into tblBills (username, idMachines, quantity, total, price, buyTime) "
                        + "values (?, ?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, idMachines);
                stm.setInt(3, quantity);
                stm.setDouble(4, price * quantity);
                stm.setDouble(5, price);
                stm.setTimestamp(6, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                int row = stm.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
