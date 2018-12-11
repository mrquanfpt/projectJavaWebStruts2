/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.search;

import java.util.List;
import quanntm.daos.tblUsersDAO;
import quanntm.dtos.tblUsersDTO;

/**
 *
 * @author QuanNTM
 */
public class SearchUserByNameAction {
    private String searchValue;
    private List<tblUsersDTO> listUser;
    
    private static final String SUCCESS = "success";

    public List<tblUsersDTO> getListUser() {
        return listUser;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    
    public SearchUserByNameAction() {
    }
    
    public String execute() throws Exception {
        tblUsersDAO dao = new tblUsersDAO();
        listUser = dao.searchUserByName(searchValue);
        
        return SUCCESS;
    }
    
}
