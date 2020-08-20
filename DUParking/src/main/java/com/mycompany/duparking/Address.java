/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

/**
 * This class models an address of a customer
 * 
 * @author Iyasu
 */
public class Address {

    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipcode;

    public Address(String streetAddress1, String city, String state, String zipcode) {
        this.streetAddress1 = streetAddress1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Address(String streetAddress1, String streetAddress2, String city, String state, String zipcode) {
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return streetAddress2 == null ?
                String.format("%s, %s, %s ", streetAddress1, city, state, zipcode):
                 String.format("%s, %s, %s, %s, %s ", streetAddress1, streetAddress2, city, state, zipcode);

    }

}
