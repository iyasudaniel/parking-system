/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duparking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Iyasu
 */
public class ParkingLotTest {

    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRate() {
        //Assumption the car will be parked for an hour
        Money expected_for_SUV = new Money(2.0, "$");
        String expectedfor_SUV_toString = expected_for_SUV.toString();
        ParkingLot plSUV = new ParkingLot();
        plSUV.getDailyRate("SUV", 1);
        Money expected_for_COMPACT = new Money(1.6, "$");
        String expected_for_COMPACT_toString = expected_for_COMPACT.toString();
        ParkingLot plCOMPACT = new ParkingLot();
        plCOMPACT.getDailyRate("COMPACT", 1);
        assertEquals(expectedfor_SUV_toString, plSUV.getDailyRate("SUV", 1).toString());
        assertEquals(expected_for_COMPACT_toString, plCOMPACT.getDailyRate("COMPACT", 1).toString());

    }

}
