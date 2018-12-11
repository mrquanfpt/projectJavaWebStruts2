/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.delete;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import quanntm.daos.tblMachinesDAO;

/**
 *
 * @author QuanNTM
 */
public class DeleteAction {
    private String idMachines;
    
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public String getIdMachines() {
        return idMachines;
    }

    public void setIdMachines(String idMachines) {
        this.idMachines = idMachines;
    }
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        tblMachinesDAO dao = new tblMachinesDAO();
        boolean result = dao.deleteItem(idMachines);
        if (result) {
            url = SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Delete Machines error!!!!!");
        }
        return url;
    }
    
}
