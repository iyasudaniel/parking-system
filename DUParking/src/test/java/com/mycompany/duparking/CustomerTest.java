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
public class CustomerTest {

    /**
     * Test of getCustomerName method, of class Customer.
     */
    @Test
    public void testGetCustomerName() {
        String expected = "Iyasu Geleta";
        Address address1 = new Address("726 Pierce Avenue'", "B24", "Drexel Hill", "PA", "19026");
        Customer c1 = new Customer("56478", "Iyasu", "Geleta", "(967) 438-7415", address1, CarType.SUV, "Mary Reed", 3, PermitType.DAILY, 5);
        assertEquals(expected, c1.getCustomerName());

    }

}
