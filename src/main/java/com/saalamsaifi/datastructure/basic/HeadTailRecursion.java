package com.saalamsaifi.datastructure.basic;

/**
 * Returns the number up to given last number
 */
public class HeadTailRecursion {

	private HeadTailRecursion() {
		super();
	}

	/**
	 * Returns the number up to last number using head recursion
	 *
	 * @param lastDigit
	 *            Number up to which digits need to be returned
	 * @return lastDigit
	 */
	public static int headRecursion(int lastDigit) {
		if (lastDigit > 9) {
			throw new IllegalArgumentException(lastDigit + " is not a digit");
		}

		if (lastDigit < 0) {
			throw new IllegalArgumentException(lastDigit + " is less than 0");
		}

		if (lastDigit > 1) {
			lastDigit = lastDigit + (headRecursion(lastDigit - 1) * 10);
		}

		return lastDigit;
	}

	/**
	 * Returns the number up to last number using tail recursion
	 *
	 * @param lastDigit
	 *            Number up to which digits need to be returned
	 * @return lastDigit
	 */
	public static int tailRecursion(int lastDigit) {
		if (lastDigit > 9) {
			throw new IllegalArgumentException(lastDigit + " is not a digit");
		}

		if (lastDigit < 0) {
			throw new IllegalArgumentException(lastDigit + " is less than 0");
		}

		if (lastDigit > 1) {
			int value = lastDigit;
			for (int i = 1; i < lastDigit; i++) {
				value *= 10;
			}
			return value + tailRecursion(lastDigit - 1);
		}

		return lastDigit;
	}
}
