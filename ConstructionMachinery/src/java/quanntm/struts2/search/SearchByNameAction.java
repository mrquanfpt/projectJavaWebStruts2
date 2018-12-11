/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.search;

import java.util.List;
import quanntm.daos.tblMachinesDAO;
import quanntm.dtos.tblMachinesDTO;

/**
 *
 * @author QuanNTM
 */

public class SearchByNameAction {
    private String searchValue;
    private List<tblMachinesDTO> listByName;
    
    private final String SUCCESS = "success";
    
    public SearchByNameAction() {
    }

    public String execute() throws Exception {
        tblMachinesDAO dao = new tblMachinesDAO();
        this.listByName = dao.searchByName(searchValue);
        
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the listByName
     */
    public List<tblMachinesDTO> getListByName() {
        return listByName;
    }
    
    
}
