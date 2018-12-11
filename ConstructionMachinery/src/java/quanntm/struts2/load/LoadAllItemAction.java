/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.struts2.load;

import java.util.List;
import quanntm.daos.tblMachinesDAO;
import quanntm.dtos.tblMachinesDTO;

/**
 *
 * @author QuanNTM
 */
public class LoadAllItemAction {

    private List<tblMachinesDTO> listAll;

    private final String SUCCESS = "success";

    public LoadAllItemAction() {
    }


    public String execute() throws Exception {
        tblMachinesDAO dao = new tblMachinesDAO();
        this.listAll = dao.getAllItems();
        return SUCCESS;
    }

    public List<tblMachinesDTO> getListAll() {
        return listAll;
    }

}
