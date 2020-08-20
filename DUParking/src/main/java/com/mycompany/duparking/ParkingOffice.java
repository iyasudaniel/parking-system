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
 * This class populates the parking System with predefined data. Additionally,
 * It register customers using Array Lists
 *
 * @author Iyasu
 */
public class ParkingOffice {

    private String parkingOfficeName;
    private List<Customer> customers = new ArrayList<>();
    private List<ParkingLot> parkinglots = new ArrayList<>();
    private Address parkingOfficeAddress;
    private PermitManager pm = new PermitManager();
    private TransactionManager tm = new TransactionManager();

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getParkingOfficeName() {
        return parkingOfficeName;
    }

    public void register(Customer c1) {
        customers.add(c1);

    }

    public ParkingPermit register(Car car) {
        return pm.register(car);
    }

    public ParkingTransaction park(Date d, ParkingPermit permit, ParkingLot lot) {
        return tm.park(d, permit, lot);

    }

    public Money getParkingCharges(ParkingPermit p) {
        return tm.getParkingCharges(p);
    }

    public Money getParkingCharges(Customer c) {
        return tm.getParkingCharges(c);

    }

    public PermitManager getPm() {
        return pm;
    }

    public TransactionManager getTm() {
        return tm;
    }

    public void addParkinglots(ParkingLot parkingLotName) {
        parkinglots.add(parkingLotName);
    }

    public void displayParkings(List<ParkingLot> parkinglots) {
        int counter = 1;
        for (ParkingLot parking : parkinglots) {
            System.out.println(counter + "." + parking.getName());
            counter++;

        }
    }

    public List<ParkingLot> LoadParkingLotsData() {

        List<ParkingLot> pms = new ArrayList<>();
        Address lotOneAddress = new Address("2308 E Evans Ave", "Denver", " CO", "80247");
        ParkingLot lotOne = new ParkingLot("301", "Evans Garage", lotOneAddress);
        pms.add(lotOne);
        Address lotTwoAddress = new Address("2201 S Gaylord St", "Denver", "CO", "80208");
        ParkingLot lotTwo = new ParkingLot("304", "Sie International Relations Comples", lotTwoAddress);
        pms.add(lotTwo);
        Address lotThreeAddress = new Address("2199 S University Blvd", "Denver", "CO", "80208");
        ParkingLot lotThree = new ParkingLot("304", "Mary Reed", lotThreeAddress);
        pms.add(lotThree);
        Address lotFourAddress = new Address("2197 S University Blvd", "Denver", "CO", "80208");
        ParkingLot lotFour = new ParkingLot("305", "University Hall", lotFourAddress);
        pms.add(lotFour);
        Address lotFiveAddress = new Address("2222 S High St", "Denver", "CO", "80210");
        ParkingLot lotFive = new ParkingLot("306", "Nelson Hall ", lotFiveAddress);
        pms.add(lotFive);
        return pms;

    }

}
