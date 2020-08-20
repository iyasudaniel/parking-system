/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.time.LocalDate;
import java.util.Date;

/**
 * This class is an improver version of the previous code
 * It add additional fields such as Cartype, parking selection
 * 
 * @author Iyasu
 */
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;
    private CarType type;
    private String parkinglotSelection;
    private int selectioninInt;
    private int hourSelection;
    private PermitType permType;
 

    public int getHourSelection() {
        return hourSelection;
    }
    private long diffDays;
    private  Date expireDateSelection;
 

    public Date getExpireDateSelection() {
        return expireDateSelection;
    }
    public Customer(String id, String firstName, String lastName,
            String phoneNumber, Address address, CarType type,
            String parkinglotSelection, int hourSelection, PermitType permType, int selectioninInt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.type = type;
        this.parkinglotSelection = parkinglotSelection;
        this.hourSelection = hourSelection;
        this.permType = permType;
        this.selectioninInt = selectioninInt;
       
    }

    public int getSelectioninInt() {
        return selectioninInt;
    }

    public PermitType getPermType() {
        return permType;
    }
      //Constructor to be used for monthly subscribers
    Customer(String id, String firstName, String lastName, String phoneNumber, Address address1, CarType type, String parkinglotSelection, Date expireDateSelection, long diffDays, PermitType permType, int selectioninInt ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address1;
        this.type = type;
        this.parkinglotSelection = parkinglotSelection;
        this.diffDays = diffDays;
        this.expireDateSelection = expireDateSelection;
           this.permType = permType;
           this.selectioninInt = selectioninInt;
    }

    public long getDiffDays() {
        return diffDays;
    }

    public String getParkinglotSelection() {
        return parkinglotSelection;
    }

    public int getParkinghour() {
        return hourSelection;
    }

    public String getType() {
        return type.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCustomerName() {
        return String.format("%s %s", firstName, lastName);
    }

}
