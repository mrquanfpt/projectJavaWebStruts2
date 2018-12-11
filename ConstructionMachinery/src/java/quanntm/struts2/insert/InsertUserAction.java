/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.insert;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblUsersDAO;

/**
 *
 * @author QuanNTM
 */
public class InsertUserAction extends ActionSupport {

    private String username;
    private String password;
    private String confirm;
    private String fullName;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Override
    public void validate() {
        if (username.length() == 0) {
            addFieldError("username", "Username must not blank!");
        }
        if (password.length() == 0) {
            addFieldError("password", "Password must not blank!");
        }
        if (confirm.length() == 0) {
            addFieldError("confirm", "Confirm must not blank!");
        }
        if (fullName.length() == 0) {
            addFieldError("fullName", "FullName must not blank!");
        }
        if (!confirm.equals(password)) {
            addFieldError("confirm", "Re-Password not match Password!");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsertUserAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        String role = "US";
        tblUsersDAO dao = new tblUsersDAO();
        boolean result = dao.createUser(username, password, fullName, role);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Insert failed!");
        }
        return url;
    }

}
