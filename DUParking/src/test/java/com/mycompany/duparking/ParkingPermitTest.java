/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Iyasu
 */
public class ParkingPermitTest {
    
    
    @Test
    public void testPrintParkingPermit_Car_int() {
        Address address = new Address("726 Pierce Avenue","B24", "Drexel Hill","PA", "19026");
        Customer  cust = new Customer("548968", "Bob", "Smith",
            "(720) -589-78541",address , CarType.COMPACT,
             "dsads", 3, PermitType.DAILY,  1);
        Car car = new Car(CarType.COMPACT,  "417-4569", cust);
        Car expected =car;
        Date date = new Date();
        ParkingPermit pp = new ParkingPermit(car, date,PermitType.DAILY);
        assertEquals(expected.owner.getCustomerName(), pp.getCar().owner.getCustomerName());
    }

 
}
