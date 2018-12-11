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
public class SearchInRangeAction {
    private double minPrice;
    private double maxPrice;
    private List<tblMachinesDTO> listInRange;
    
    private final String SUCCESS = "success";
    
    public SearchInRangeAction() {
    }
    
    
    public String execute() throws Exception {
        tblMachinesDAO dao = new tblMachinesDAO();
        this.listInRange = dao.searchInRange(minPrice, maxPrice);
        
        return SUCCESS;
    }

    /**
     * @return the minPrice
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice the minPrice to set
     */
    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @return the maxPrice
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxPrice the maxPrice to set
     */
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return the listInRange
     */
    public List<tblMachinesDTO> getListInRange() {
        return listInRange;
    }
    
    
}
