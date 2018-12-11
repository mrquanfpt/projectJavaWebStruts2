/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author QuanNTM
 */
public class tblMachinesDTO implements Serializable{
    private String idMachines;
    private String picture;
    private String nameMachines;
    private String description;
    private Date published;
    private double price;

    public tblMachinesDTO(String idMachines, String picture, String nameMachines, String description, Date published, double price) {
        this.idMachines = idMachines;
        this.picture = picture;
        this.nameMachines = nameMachines;
        this.description = description;
        this.published = published;
        this.price = price;
    }

    public String getIdMachines() {
        return idMachines;
    }

    public void setIdMachines(String idMachines) {
        this.idMachines = idMachines;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof tblMachinesDTO )) {
            return false;
        }
        tblMachinesDTO other = (tblMachinesDTO) obj;
        if ((this.idMachines == null && other.idMachines != null)
            || (this.idMachines != null && !this.idMachines.equals(other.idMachines))){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMachines != null ? idMachines.hashCode() : 0);
        return hash;
    }
    
}
