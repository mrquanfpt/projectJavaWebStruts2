/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.delete;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblUsersDAO;

/**
 *
 * @author QuanNTM
 */
public class DeleteUserAction {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    
    public DeleteUserAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        tblUsersDAO dao = new tblUsersDAO();
        boolean result = dao.deleteUser(username);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Delete User error!!!!!");
        }
        return url;
    }
    
}
