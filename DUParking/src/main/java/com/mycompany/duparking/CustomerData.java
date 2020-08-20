/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

/**
 *
 * @author Iyasu
 */
public class CustomerData {
    Customer customer;
    Car car;

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }
    
    public CustomerData(Customer cust, Car car ){
        this.customer = cust;
        this.car = car ;
    }
    
}
