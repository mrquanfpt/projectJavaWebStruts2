/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.cart;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import quanntm.daos.tblMachinesDAO;
import quanntm.dtos.tblMachinesDTO;

/**
 *
 * @author QuanNTM
 */
public class AddToCartAction {
    private String item;
    
    private final String SUCCESS = "success";


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public AddToCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        
        if (cart == null) {
            cart = new CartObj();
        }
        
        tblMachinesDAO dao = new tblMachinesDAO();
        tblMachinesDTO dto = dao.getItem(item);
        cart.addItemToCart(dto);
        session.put("CART", cart);
        
        return SUCCESS;
    }
    
}
