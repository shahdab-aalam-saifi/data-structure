package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class RadixSort {
	private static final int _2 = 2;
	private static final int _10 = 10;

	public RadixSort() {
		super();
	}

	public int[] sort(int[] unsortedElements, boolean isAscending) {
		if (unsortedElements == null) {
			throw new IllegalArgumentException("unsortedElements == null");
		}

		int length = unsortedElements.length;

		if (length == 0 || length == 1) {
			return unsortedElements;
		}

		if (!canBeSorted(unsortedElements)) {
			throw new UnsupportedOperationException("elements cannot be sorted by Radix sort algorithm");
		}

		int max = getMaximum(unsortedElements);

		for (int exponent = 1; max / exponent > 0; exponent *= _10) {
			countSort(unsortedElements, exponent);
		}

		if (isAscending) {
			for (int i = 0; i < length / _2; i++) {
				int temp = unsortedElements[i];
				unsortedElements[i] = unsortedElements[length - i - 1];
				unsortedElements[length - i - 1] = temp;
			}
		}

		return unsortedElements;
	}

	/***
	 * Checks whether array of integer can be sorted by radix algorithms
	 * 
	 * @param elements
	 * @return canSort
	 */
	private static boolean canBeSorted(int[] elements) {
		int length = elements.length;
		boolean canSort = true;

		for (int i = 0; i < length; i++) {
			if (elements[i] < 0) {
				canSort = false;
				break;
			}
		}

		return canSort;
	}

	/***
	 * Returns the maximum from the integer array
	 * 
	 * @param elements
	 * @return max
	 */
	private static int getMaximum(int[] elements) {
		int length = elements.length;
		int max = 0;

		for (int i = 0; i < length; i++) {
			if (elements[i] > max) {
				max = elements[i];
			}
		}

		return max;
	}

	/***
	 * Returns the intermediate result of radix sort
	 * 
	 * @param elements
	 *            array of positive integers
	 * @param exponent
	 *            digit's place i.e. unit, ten, hundred
	 * @return elements
	 */
	private static int[] countSort(int[] elements, int exponent) {
		int length = elements.length;

		int[] count = new int[_10];

		for (int i = 0; i < length; i++) {
			count[(elements[i] / exponent) % _10]++;
		}

		for (int i = 1; i < _10; i++) {
			count[i] += count[i - 1];
		}

		int[] output = new int[length];

		for (int i = length - 1; i >= 0; i--) {
			output[count[(elements[i] / exponent) % _10] - 1] = elements[i];
			count[(elements[i] / exponent) % _10]--;
		}

		for (int i = 0; i < length; i++) {
			elements[i] = output[i];
		}
		return elements;
	}

	/**
	 * @param type
	 * @return
	 */
	public String getTimeComplexity(TimeComplexity type) {
		String complexity = BigOh.O_INVALID.getComplexity();

		if (type == TimeComplexity.BEST || type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			complexity = BigOh.O_NK.getComplexity();
		}

		return complexity;
	}

	/**
	 * @return
	 */
	public String getSpaceComplexity() {
		return BigOh.O_N_K.getComplexity();
	}
}
