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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import quanntm.dtos.tblMachinesDTO;
import quanntm.utils.DBUtils;

/**
 *
 * @author QuanNTM
 */
public class tblMachinesDAO implements Serializable{
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
    
    public List<tblMachinesDTO> getAllItems() throws SQLException {
        List<tblMachinesDTO> listAll = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select idMachines, picture, nameMachines, description, "
                        + "published, price from tblMachines";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()) {
                    String idMachines = rs.getString("idMachines");
                    String picture = rs.getString("picture");
                    String nameMachines = rs.getString("nameMachines");
                    String description = rs.getString("description");
                    Date published = rs.getDate("published");
                    double price = rs.getDouble("price");
                    listAll.add(new tblMachinesDTO(idMachines, picture, nameMachines, description, published, price));
                }
            }
            Collections.sort(listAll, new Comparator<tblMachinesDTO>() {
                @Override
                public int compare(tblMachinesDTO t, tblMachinesDTO t1) {
                    return t1.getPublished().compareTo(t.getPublished());
                }
            });
        } catch (SQLException e) {
            
        } finally {
            closeConnection();
        }
        return listAll;
    }
    
    public List<tblMachinesDTO> searchInRange(double minPrice, double maxPrice) throws SQLException {
        List<tblMachinesDTO> listInRange = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select idMachines, picture, nameMachines, description, "
                        + "published, price from tblMachines where price between ? and ?";
                stm = conn.prepareStatement(sql);
                stm.setDouble(1, minPrice);
                stm.setDouble(2, maxPrice);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idMachines = rs.getString("idMachines");
                    String picture = rs.getString("picture");
                    String nameMachines = rs.getString("nameMachines");
                    String description = rs.getString("description");
                    Date published = rs.getDate("published");
                    double price = rs.getDouble("price");
                    listInRange.add(new tblMachinesDTO(idMachines, picture, nameMachines, description, published, price));
                }
            }
        } catch (SQLException e) {
            
        } finally {
            closeConnection();
        }
        return listInRange;
    }
    
    public List<tblMachinesDTO> searchByName(String searchValue) throws SQLException {
        List<tblMachinesDTO> listByName = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select idMachines, picture, nameMachines, description, "
                        + "published, price from tblMachines where nameMachines like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String idMachines = rs.getString("idMachines");
                    String picture = rs.getString("picture");
                    String nameMachines = rs.getString("nameMachines");
                    String description = rs.getString("description");
                    Date published = rs.getDate("published");
                    double price = rs.getDouble("price");
                    listByName.add(new tblMachinesDTO(idMachines, picture, nameMachines, description, published, price));
                }
            }
        } catch (SQLException e) {
            
        } finally {
            closeConnection();
        }
        return listByName;
    }
    
    public boolean deleteItem(String idMachines) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Delete from tblMachines where idMachines = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, idMachines);
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
    
    public boolean updateItem(String idMachines, String nameMachines, String description, Date published, double price) throws SQLException {
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblMachines set nameMachines = ?, description = ?, "
                        + "published = ?, price = ? where idMachines = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, nameMachines);
                stm.setString(2, description);
                stm.setDate(3, (java.sql.Date) published);
                stm.setDouble(4, price);
                stm.setString(5, idMachines);
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
    
    public tblMachinesDTO getItem(String id) throws Exception {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select idMachines, picture, nameMachines, description, "
                        + "published, price from tblMachines where idMachines = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String idMachines = rs.getString("idMachines");
                    String picture = rs.getString("picture");
                    String nameMachines = rs.getString("nameMachines");
                    String description = rs.getString("description");
                    Date published = rs.getDate("published");
                    double price = rs.getDouble("price");
                    
                    tblMachinesDTO dto = new tblMachinesDTO(idMachines, picture, nameMachines, description, published, price);
                    return dto;
                }
            }
        } finally {
            closeConnection();
        }
        return null;
    }
}
