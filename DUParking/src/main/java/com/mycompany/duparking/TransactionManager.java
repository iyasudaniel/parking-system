/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

//import static com.mycompany.duparking.Main.searchParkingLotObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iyasu
 */
public class TransactionManager {
      private List<ParkingTransaction> transactions = new ArrayList<>();

    public List<ParkingTransaction> getTransactions() {
        return transactions;
    }
      public ParkingTransaction park(Date date, ParkingPermit parkingPermit, ParkingLot parkingLot){
           ParkingTransaction pt = new ParkingTransaction(date, parkingPermit, parkingLot);
           transactions.add(pt);
        return pt;  
      } 
public Money getParkingCharges(ParkingPermit parkingPermit){
     Money amtresult = null;
    for ( ParkingTransaction pt: transactions){
        if(parkingPermit.getId().equals(pt.getPermit().getId()))
          amtresult = pt.getChargedAmount();
    }
    return amtresult;
}
public Money getParkingCharges(Customer customer){
     Money amtresult = null;
    for ( ParkingTransaction pt: transactions){
        if(pt.getPermit().getCar().owner.equals(customer))
          amtresult = pt.getChargedAmount();
    }
    return amtresult;
}

    
       public void listall(){
    for (ParkingTransaction transact: transactions){
        System.out.println( transact.getPermit().getId() + " " 
                + transact.getPermit().getCar().owner.getFirstName() + " "
                +transact.getPermit().getCar().licensePlate );
        
    }
    }
    
}
