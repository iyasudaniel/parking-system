/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

/** 
 *This class represents a Parking Lot
 * It give the dailyRate price for different type of Cars
 * 
 * @author Iyasu
 */
public class ParkingLot  {
    CarType type;
    private String id;
    private String name;
    private Address address;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public ParkingLot() {
    }

    public ParkingLot(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
  public Money getDailyRate(String carTypeInput, int parkingHour){
      double hourlyRate = 2.0;
      double price = 0.0;
      if(carTypeInput.equalsIgnoreCase(CarType.SUV.toString())){
          type =CarType.SUV;
          price =hourlyRate * parkingHour;
      }
      else if(carTypeInput.equalsIgnoreCase(CarType.COMPACT.toString())){
          type = CarType.COMPACT;
          price =  (double)(0.8 * hourlyRate) * parkingHour;
      }
      
      
        return new Money(price, "$");
    }
  public Money getMonthlyRate(String carTypeInput, int numberOfDays){
      double dailyRate = 1.50;
      double price = 0.0;
      if(carTypeInput.equalsIgnoreCase(CarType.SUV.toString())){
          type =CarType.SUV;
          price =dailyRate * numberOfDays ;
      }
      else if(carTypeInput.equalsIgnoreCase(CarType.COMPACT.toString())){
          type = CarType.COMPACT;
          price =  (double)(0.8 * dailyRate) * numberOfDays;
      }
      
      
        return new Money(price, "$");
    }
  
  public String addressToString(){
      return address.toString();
  }
    
    
}
