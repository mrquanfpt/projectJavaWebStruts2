/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.update;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblUsersDAO;

/**
 *
 * @author QuanNTM
 */
public class UpdateUserAction {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String password;
    private String fullName;
    
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    public UpdateUserAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        tblUsersDAO dao = new tblUsersDAO();
        boolean result = dao.updateUser(username, password, fullName);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Update User Error!!!!!");
        }
        return url;
    }
    
}
