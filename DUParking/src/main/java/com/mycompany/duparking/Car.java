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
public class Car {
         CarType  type;
         String licensePlate;
         Customer owner;

    public Car(CarType type, String licensePlate, Customer owner) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    public CarType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Customer getOwner() {
        return owner;
    }

         
}
