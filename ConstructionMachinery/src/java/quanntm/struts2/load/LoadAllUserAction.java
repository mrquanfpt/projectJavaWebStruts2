/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.load;

import java.util.List;
import quanntm.daos.tblUsersDAO;
import quanntm.dtos.tblUsersDTO;

/**
 *
 * @author QuanNTM
 */
public class LoadAllUserAction {
    private List<tblUsersDTO> listUser;
    
    private final String SUCCESS = "success";
    
    public LoadAllUserAction() {
    }
    
    public String execute() throws Exception {
        tblUsersDAO dao = new tblUsersDAO();
        this.listUser = dao.getAllUsers();
        return SUCCESS;
    }

    public List<tblUsersDTO> getListUser() {
        return listUser;
    }
    
}
