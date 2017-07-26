/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author Rahul
 */
public class Employee {
    public String name;
    public String address;

    public Employee() {
        System.out.println("employee obj created...");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
