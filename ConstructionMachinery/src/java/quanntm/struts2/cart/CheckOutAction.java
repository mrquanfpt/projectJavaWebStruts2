/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.cart;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblBillsDAO;

/**
 *
 * @author QuanNTM
 */
public class CheckOutAction {
    private String idMachines;
    private String username;
    private int quantity;
    private double price;
    
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public String getIdMachines() {
        return idMachines;
    }

    public void setIdMachines(String idMachines) {
        this.idMachines = idMachines;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    public CheckOutAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        tblBillsDAO dao = new tblBillsDAO();
        boolean result = dao.insertBill(username, idMachines, quantity, price);
        if (result) {
            Map session = ServletActionContext.getContext().getSession();
            CartObj cart = (CartObj) session.get("CART");
            cart.removeItemFromCart(idMachines);
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Checkout error!!!!!");
        }
        return url;
    }
    
}
