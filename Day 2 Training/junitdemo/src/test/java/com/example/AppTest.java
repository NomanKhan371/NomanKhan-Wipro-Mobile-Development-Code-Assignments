package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void addTest() {
        int sum = App.add(5, 5); // 10
        assertEquals(10, sum);       
    }

    @Test
    public void isEvenTest() {
        boolean isEven = App.isEven(7); // 10
        assertFalse(isEven);
    }
}