package com.saalamsaifi.datastructure.basic;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HeadTailRecursionTest {
    @Test
    public void testHeadRecursionOfZero() {
        int actual = HeadTailRecursion.headRecursion(0);

        assertEquals(0, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHeadRecursionOfNegative() {
        HeadTailRecursion.headRecursion(-1);
    }

    @Test
    public void testHeadRecursionOfDigit() {
        int actual = HeadTailRecursion.headRecursion(5);

        assertEquals(12345, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHeadRecursionOfNumber() {
        HeadTailRecursion.headRecursion(10);
    }

    @Test
    public void testTailRecursionOfZero() {
        int actual = HeadTailRecursion.tailRecursion(0);

        assertEquals(0, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTailRecursionOfNegative() {
        HeadTailRecursion.tailRecursion(-1);
    }

    @Test
    public void testTailRecursionOfDigit() {
        int actual = HeadTailRecursion.tailRecursion(5);

        assertEquals(54321, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTailRecursionOfNumber() {
        HeadTailRecursion.tailRecursion(10);
    }
}
