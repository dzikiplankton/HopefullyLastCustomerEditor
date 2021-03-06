/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hopefullylastcustomereditor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author zakp2 <dzikiplankton@gmail.com>
 */
@Entity
@ViewScoped
@ManagedBean(name = "customer")
public class Customer implements Serializable {

    public Customer( String name, String surname, String phone, String comment) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.registrationDate = new Date().from(Instant.now());
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.comment = comment;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registrationDate;
    private String name;
    private String surname;
    private String phone;
    private String comment;

    public Customer() {
    }

    
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hopefullylastcustomereditor.Customer[ id=" + id + " ]";
    }
    
}
