/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Iyasu
 */
public class PermitManagerTest {
    
   
    @Test
    public void testRegister() {
        
         List<ParkingTransaction> transactions = new ArrayList<>();
         Address address = new Address("726 Pierce Avenue","B24", "Drexel Hill","PA", "19026");
        Customer  cust = new Customer("548968", "Bob", "Smith",
            "(720) -589-78541",address , CarType.COMPACT,
             "dsads", 3, PermitType.DAILY,  1);
        Car car = new Car(CarType.COMPACT,  "417-4569", cust);
        Date date = new Date(2020,11,15);
            ParkingPermit pp = new ParkingPermit(car, date,PermitType.DAILY);
            ParkingLot plCOMPACT = new ParkingLot();
         ParkingTransaction pt = new ParkingTransaction(date,pp,plCOMPACT );
          
          transactions.add(pt);
          ParkingTransaction expected = transactions.get(0);
          TransactionManager tm =new TransactionManager();
          tm.park(date, pp, plCOMPACT);
          assertEquals(expected.getPermit().getCar().type,tm.getTransactions().get(0).getPermit().getCar().type);
         
        
    }

    
}
