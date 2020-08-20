/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

/**
 * The class represents a money
 *
 * @author Iyasu
 */
public class Money {

    // As the calculation requires fractional numbers I have made the data
    //type to be double.
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // returns a formatted string representation of the amount
    @Override
    public String toString() {
        return String.format("%s%.2f", currency, amount);

    }

}
