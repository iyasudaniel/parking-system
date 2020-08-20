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
public class AddressTest {
    
  

    /**
     * Test of getAddress method, of class Address.
     */
    @Test
    public void testGetAddress() {
        String expected1 = "726 Pierce Avenue, B24, Drexel Hill, PA, 19026 ";
        String expected2 = "726 Pierce Avenue, Drexel Hill, PA ";
        Address address1 = new Address("726 Pierce Avenue","B24", "Drexel Hill","PA", "19026" );
        Address address2 = new Address("726 Pierce Avenue", "Drexel Hill","PA", "19026" );
        assertEquals(expected1, address1.getAddress());
        assertEquals(expected2, address2.getAddress());
    }
    
}
