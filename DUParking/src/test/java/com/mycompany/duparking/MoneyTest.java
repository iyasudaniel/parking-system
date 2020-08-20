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
public class MoneyTest {

    /**
     * Test of toString method, of class Money.
     */
    @Test
    public void testToString() {

        String expected = "$2.00";
        Money m = new Money(2.0, "$");
        assertEquals(expected, m.toString());

    }

}
