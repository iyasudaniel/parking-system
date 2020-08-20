/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Iyasu
 */
public class ParkingPermit {

    private String id;

    private Car car;
    private Date expiration;
    private PermitType permType;
    private static int IdCounter = 1;

    public ParkingPermit(Car car, Date expiration, PermitType permType) {
        this.car = car;
        this.expiration = expiration;
        this.id = "DUPS-" + Integer.toString(IdCounter);
        IdCounter++;
        this.permType = permType;
    }

    private Date getExpiration() {
        return expiration;
    }

    public String getId() {
        return id;
    }

    public PermitType getPermType() {
        return permType;
    }

    public Car getCar() {
        return car;
    }

    public void printParkingPermit(Car car) {
        System.out.println("************************");
        System.out.println("University of Denver ");
        System.out.println("Monthly Parking Permit");
        System.out.println("************************");
        System.out.println("Parking Permit number:" + id);
        System.out.println("Plate Number: " + car.getLicensePlate());

        LocalDate formatted_expire = convertToLocalDateViaInstant(expiration);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Expiration Date: " + formatted_expire.getMonth() + formatted_expire.getDayOfMonth() + ", " + formatted_expire.getYear());
        System.out.println("************************");

    }

    public void printParkingPermit(Car car, int hrs) {
        LocalTime time = LocalTime.now();
        LocalTime expireTime = time.plusHours(hrs);
        System.out.println("************************");
        System.out.println("University of Denver ");
        System.out.println("Daily Parking Permit");
        System.out.println("************************");
        System.out.println("Parking Permit number:" + id);
        System.out.println("Plate Number: " + car.getLicensePlate());
        System.out.println("Expiration Time: " + expireTime.getHour() + " : " + expireTime.getMinute());
        System.out.println("************************");

    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
