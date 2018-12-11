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
import java.util.ArrayList;
import java.util.List;
import quanntm.dtos.tblUsersDTO;
import quanntm.utils.DBUtils;

/**
 *
 * @author QuanNTM
 */
public class tblUsersDAO implements Serializable{

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

    public String checkLogin(String username, String password) throws SQLException {
        String role = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select role from tblUsers Where username = ? and password = ? and status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("role");
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean createUser(String username, String password, String fullName, String role) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert into tblUsers (username, password, fullName, role, status) values (?, ?, ?, ?, 1)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setString(4, role);
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

    public List<tblUsersDTO> searchUserByName(String searchValue) throws SQLException {
        List<tblUsersDTO> listUser = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select username, password, fullName from tblUsers where fullName like ? and (role like '%US%')"
                        + "and status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()) {
                    String username = rs.getString("username");
                    String fullName = rs.getString("fullName");
                    String password = rs.getString("password");
                    tblUsersDTO dto = new tblUsersDTO(username, fullName, password);
                    listUser.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }
    
    public boolean deleteUser(String username) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblUsers set status = 0 where username = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
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
    
    public boolean updateUser(String username, String password, String fullName) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblUsers set fullName = ?, password = ? "
                        + "where username = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, fullName);
                stm.setString(2, password);
                stm.setString(3, username);
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
    
    public List<tblUsersDTO> getAllUsers() throws SQLException {
        List<tblUsersDTO> listUser = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select username, password, fullName from tblUsers where status = 1";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()) {
                    String username = rs.getString("username");
                    String fullName = rs.getString("fullName");
                    String password = rs.getString("password");
                    tblUsersDTO dto = new tblUsersDTO(username, fullName, password);
                    listUser.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }

}
