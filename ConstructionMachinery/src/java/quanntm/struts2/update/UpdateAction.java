/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.update;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblMachinesDAO;

/**
 *
 * @author QuanNTM
 */
public class UpdateAction {
    private String idMachines;
    private String nameMachines;
    private String description;
    private Date published;
    private double price;
    
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public String getIdMachines() {
        return idMachines;
    }

    public void setIdMachines(String idMachines) {
        this.idMachines = idMachines;
    }

    public String getNameMachines() {
        return nameMachines;
    }

    public void setNameMachines(String nameMachines) {
        this.nameMachines = nameMachines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        tblMachinesDAO dao = new tblMachinesDAO();
        boolean result = dao.updateItem(idMachines, nameMachines, description, published, price);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Update Machines Error!!!!!");
        }
        return url;
    }
    
}
