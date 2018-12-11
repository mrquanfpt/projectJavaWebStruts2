/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.login;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblUsersDAO;

/**
 *
 * @author QuanNTM
 */
public class LoginAction {

    private String username;
    private String password;

    private final String ADMIN = "admin";
    private final String USER = "user";
    private final String ERROR = "error";

    public LoginAction() {
    }

    public String execute() throws Exception {
        tblUsersDAO dao = new tblUsersDAO();
        String role = dao.checkLogin(username, password);
        String url = ERROR;
        if (role != null) {
            role = role.trim();
            Map session = ActionContext.getContext().getSession();
            session.put("ROLE", role);
            session.put("USERNAME", username);
            if (role.equals("AD")) {
                url = ADMIN;
            } else if (role.equals("US")) {
                url = USER;
            }
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Invalid username or password!!!!!");
        }

        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
