/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import quanntm.dtos.tblMachinesDTO;

/**
 *
 * @author QuanNTM
 */
public class CartObj implements Serializable{
    private String username;
    private Map<tblMachinesDTO, Integer> items;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<tblMachinesDTO, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(tblMachinesDTO item) {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        
        int quantity = 1;
        if (this.items.containsKey(item)) {
            quantity = this.items.get(item) + 1;
        }
        
        this.items.put(item, quantity);
    }
    
    public void removeItemFromCart(tblMachinesDTO item) {
        if (this.items == null) {
            return;
        }
        
        if (this.items.containsKey(item)) {
            this.items.remove(item);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
    public void removeItemFromCart(String id) {
        if (this.items == null) {
            return;
        }
        
        tblMachinesDTO dto = new tblMachinesDTO(id, "", "", "", null, 0);
        if (this.items.containsKey(dto)) {
            this.items.remove(dto);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
}
