/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.insert;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblFeedbacksDAO;

/**
 *
 * @author QuanNTM
 */
public class InsertFeedbackAction {
    private String firstName;
    private String lastName;
    private String city;
    private String subject;
    
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    
    public InsertFeedbackAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        tblFeedbacksDAO dao = new tblFeedbacksDAO();
        boolean result = dao.insertFeedback(firstName, lastName, city, subject);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Push a feedbacks is error!! Try again...");
        }
        return url;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
