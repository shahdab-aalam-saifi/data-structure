package com.saalamsaifi.datastructure.basic;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FactorialTest {
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testFactorialOfNegativeNumberIterative() {
		Factorial.factorialIterative(-10);
	}

	@Test
	public void testFactorialOfZeroIterative() {
		int actual = Factorial.factorialIterative(0);
		assertEquals(1, actual);
	}

	@Test
	public void testFactorialOfNumberIterative() {
		int actual = Factorial.factorialIterative(5);
		assertEquals(120, actual);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testFactorialOfNegativeNumberRecursive() {
		Factorial.factorialRecursive(-10);
	}

	@Test
	public void testFactorialOfZeroRecursive() {
		int actual = Factorial.factorialRecursive(0);
		assertEquals(1, actual);
	}

	@Test
	public void testFactorialOfNumberRecursive() {
		int actual = Factorial.factorialRecursive(5);
		assertEquals(120, actual);
	}
}
