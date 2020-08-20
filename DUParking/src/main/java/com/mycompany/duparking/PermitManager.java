/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iyasu
 */
public class PermitManager {

    private static List<ParkingPermit> permits = new ArrayList<>();

    public List<ParkingPermit> getPermits() {
        return permits;
    }

    public void authorizePermit(Car car, Customer customer) {
        System.out.println("Printing Parking Permit");
        //1 Car c = new Car(car.type, car.licensePlate, customer);
        PermitManager pm = new PermitManager();
        System.out.println(customer.getType());
        if (customer.getPermType().equals(PermitType.DAILY)) {
            ParkingPermit pp = pm.register(car);
            Date date = new Date();
            ParkingLot pl = new ParkingLot();

            pp.printParkingPermit(car, customer.getHourSelection());
//                        
        } else {
            Date date = new Date();
            ParkingPermit pp = pm.register(car);
            pp.printParkingPermit(car);
//                        ParkingTransaction pt = new ParkingTransaction(date, pp, searchParkingLotObject(selection));
//                        pt.printTransaction();
        }

    }

    public ParkingPermit register(Car car) {
        ParkingPermit pp = new ParkingPermit(car, car.owner.getExpireDateSelection(), car.owner.getPermType());
        permits.add(pp);
        return pp;
    }

    public void listall() {
        for (ParkingPermit permit : permits) {
            System.out.println(permit.getId() + " " + permit.getCar().owner.getFirstName() + " " + permit.getCar().getLicensePlate());

        }
    }

    public ParkingLot searchParkingLotObject(int selection) {
        ParkingLot lot = null;
        switch (selection) {
            case 1:
                Address lotOneAddress = new Address("2308 E Evans Ave", "Denver", " CO", "80247");
                lot = new ParkingLot("301", "Evans Garage", lotOneAddress);
            case 2:
                Address lotTwoAddress = new Address("2201 S Gaylord St", "Denver", "CO", "80208");
                lot = new ParkingLot("304", "Sie International Relations Comples", lotTwoAddress);
            case 3:
                Address lotThreeAddress = new Address("2199 S University Blvd", "Denver", "CO", "80208");
                lot = new ParkingLot("304", "Mary Reed", lotThreeAddress);
            case 4:
                Address lotFourAddress = new Address("2197 S University Blvd", "Denver", "CO", "80208");
                lot = new ParkingLot("305", "University Hall", lotFourAddress);
            case 5:
                Address lotFiveAddress = new Address("2222 S High St", "Denver", "CO", "80210");
                lot = new ParkingLot("306", "Nelson Hall ", lotFiveAddress);

        }

        return lot;

    }

}
