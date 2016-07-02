/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hopefullylastcustomereditor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zakp2 <dzikiplankton@gmail.com>
 */
@ManagedBean (name= "customerService")
@ApplicationScoped
public class CustomerService {

    private final static String[] names;
     
    private final static String[] surnames;
     
    static {
        names = new String[10];
        names[0] = "Black";
        names[1] = "White";
        names[2] = "Green";
        names[3] = "Red";
        names[4] = "Blue";
        names[5] = "Orange";
        names[6] = "Silver";
        names[7] = "Yellow";
        names[8] = "Brown";
        names[9] = "Maroon";
         
        surnames = new String[10];
        surnames[0] = "BMW";
        surnames[1] = "Mercedes";
        surnames[2] = "Volvo";
        surnames[3] = "Audi";
        surnames[4] = "Renault";
        surnames[5] = "Fiat";
        surnames[6] = "Volkswagen";
        surnames[7] = "Honda";
        surnames[8] = "Jaguar";
        surnames[9] = "Ford";
    }
    
    public List<Customer> createCustomers(int size) {
        List<Customer> list = new ArrayList<Customer>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Customer(getRandomName(),getRandomSurname(),getRandomPhone(),getRandomComment()));
        }
         
        return list;
    }
    
     private String getRandomName() {
        return names[(int) (Math.random() * 10)];
    }
     
    private String getRandomSurname() {
        return surnames[(int) (Math.random() * 10)];
    }
    
    public int getRandomPhone() {
        return (int) (100000000 + Math.random() * 100000000);
    }
    
    public String getRandomComment() {
       return new BigInteger(130, new Random()).toString(32);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
