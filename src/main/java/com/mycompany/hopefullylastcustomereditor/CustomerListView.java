/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hopefullylastcustomereditor;

import java.io.Serializable;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author zakp2 <dzikiplankton@gmail.com>
 */
@ManagedBean
@SessionScoped
public class CustomerListView implements Serializable {

    private List<Customer> customers;

    private List<Customer> filteredCustomers;
    
    private Customer current;
 
    @ManagedProperty("#{customerService}")
    private CustomerService service;

    @PostConstruct
    public void init() {
        customers = service.createCustomers(10);
        current = new Customer();
    }

    public Customer getCurrent() {
        return current;
    }

    public void setCurrent(Customer current) {
        this.current = current;
    }
    
    
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getFilteredCustomers() {
        return filteredCustomers;
    }

    public void setFilteredCustomers(List<Customer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }

    public CustomerService getService() {
        return service;
    }

    public void setService(CustomerService service) {
        this.service = service;
    }
    public void addCustomer(){
        
        customers.add(new Customer(current.getName(),current.getSurname(),current.getPhone(),current.getComment()));
    }

    
    public void destroyCustomer(Customer desCus){
        customers.remove(desCus);
    }
    
    public void onRowEdit() {
        FacesMessage msg = new FacesMessage("Customer Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel() {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
}
