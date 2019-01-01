package com.saalamsaifi.datastructure.basic;

/**
 * Calculates the factorial of up to given number
 */
public class Factorial {

	private Factorial() {
		super();
	}

	/**
	 * Returns the factorial of the given number using iterative approach
	 *
	 * @param lastNumber
	 *            Number of which factorial needs to be calculated
	 * @return factorial
	 */
	public static int factorialIterative(int lastNumber) {
		int factorial = 1;

		if (lastNumber < 0) {
			throw new IllegalArgumentException(
					"Factorial of negative number is not possible, hence " + lastNumber + "! is not possible");
		}

		if (lastNumber == 0) {
			return factorial;
		}

		for (int number = 1; number <= lastNumber; number++) {
			factorial *= number;
		}

		return factorial;
	}

	/**
	 * Returns the factorial of the given number using recursive approach
	 *
	 * @param lastNumber
	 *            Number of which factorial needs to be calculated
	 * @return factorial
	 */
	public static int factorialRecursive(int lastNumber) {
		int factorial = 1;

		if (lastNumber < 0) {
			throw new IllegalArgumentException(
					"Factorial of negative number is not possible, hence " + lastNumber + "! is not possible");
		}

		if (lastNumber == 0) {
			return factorial;
		}

		return lastNumber * factorialRecursive(lastNumber - 1);
	}
}
