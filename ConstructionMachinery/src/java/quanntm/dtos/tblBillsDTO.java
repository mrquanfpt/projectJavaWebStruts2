/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author QuanNTM
 */
public class tblBillsDTO implements Serializable{
    private int idBill;
    private String idMachines;
    private String username;
    private int quantity;
    private double total;
    private double price;
    private Date buyTime;

    public tblBillsDTO(int idBill, String idMachines, int quantity, double total, double price, Date buyTime) {
        this.idBill = idBill;
        this.idMachines = idMachines;
        this.quantity = quantity;
        this.total = total;
        this.price = price;
        this.buyTime = buyTime;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getIdMachines() {
        return idMachines;
    }

    public void setIdMachines(String idMachines) {
        this.idMachines = idMachines;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
