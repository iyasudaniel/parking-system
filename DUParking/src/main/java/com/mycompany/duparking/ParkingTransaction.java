/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Iyasu
 */
public class ParkingTransaction {
    
    private Date date;
    private ParkingPermit permit;
    private ParkingLot parkingLot;
    private Money chargedAmount;

    public ParkingTransaction(Date date, ParkingPermit permit, ParkingLot parkingLot) {
        this.date = date;
        this.permit = permit;
        this.parkingLot = parkingLot;
        if (permit.getPermType().equals(permit.getPermType().DAILY)) {
        this.chargedAmount = parkingLot.getDailyRate(permit.getCar().owner.getType(), permit.getCar().owner.getHourSelection());
        } else {
           this.chargedAmount = parkingLot.getMonthlyRate(permit.getCar().owner.getType(), (int) permit.getCar().owner.getDiffDays());
        }
       
    }
//

    public ParkingPermit getPermit() {
        return permit;
    }
//

    public Money getChargedAmount() {
        return chargedAmount;
    }

    public void printTransaction() {
        System.out.println("University of Denver Parking System Invoice");
        System.out.println("********************************************");
        System.out.println("Date: " + date);
        System.out.println("Permit ID: " + permit.getId());
        System.out.println("Customer Name: " + permit.getCar().owner.getCustomerName());
        System.out.println("Permit Type: " + permit.getCar().owner.getPermType());
        System.out.println("Parking Lot Name: " + parkingLot.getName());
        if (permit.getPermType().equals(permit.getPermType().DAILY)) {
            System.out.println("Total Amount: " + parkingLot.getDailyRate(permit.getCar().owner.getType(), permit.getCar().owner.getHourSelection()));
        } else {
            System.out.println("Total Amount: " + getChargedAmount());
        }

        System.out.println("*******************************************");

    }

}
