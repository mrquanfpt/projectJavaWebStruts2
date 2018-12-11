/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.cart;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author QuanNTM
 */
public class RemoveItemFromCartAction {
    private String[] selectedItem;
    
    private final String SUCCESS = "success";
    
    public RemoveItemFromCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        
        if (cart != null) {
            for (String item : selectedItem) {
                cart.removeItemFromCart(item);
            }
            session.put("CART", cart);
        }
        return SUCCESS;
    }

    public String[] getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String[] selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    
    
}
