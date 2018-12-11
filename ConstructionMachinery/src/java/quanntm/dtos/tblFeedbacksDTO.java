/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanntm.dtos;

import java.io.Serializable;

/**
 *
 * @author QuanNTM
 */
public class tblFeedbacksDTO implements Serializable{
    private String idFB;
    private String firstName;
    private String lastName;
    private String city;
    private String subject;

    public tblFeedbacksDTO(String idFB, String firstName, String lastName, String city, String subject) {
        this.idFB = idFB;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.subject = subject;
    }

    public String getIdFB() {
        return idFB;
    }

    public void setIdFB(String idFB) {
        this.idFB = idFB;
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
