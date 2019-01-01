package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class MergeSort implements SortingAlgorithm {
	/**
	 * 
	 */
	public MergeSort() {
		super();
	}

	/**
	 * @param elements
	 * @param lowerBound
	 * @param upperBound
	 * @param isAscending
	 * @return
	 */
	private static <T extends Comparable<T>> T[] mergeSort(T[] elements, int lowerBound, int upperBound,
			boolean isAscending) {
		if (lowerBound < upperBound) {
			int middle = lowerBound + (upperBound - lowerBound) / 2;

			mergeSort(elements, lowerBound, middle, isAscending);
			mergeSort(elements, middle + 1, upperBound, isAscending);
			merge(elements, lowerBound, middle, upperBound, isAscending);
		}
		return elements;
	}

	/**
	 * @param elements
	 * @param lowerBound
	 * @param middle
	 * @param upperBound
	 * @param isAscending
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] elements, int lowerBound, int middle, int upperBound,
			boolean isAscending) {
		T[] temp = (T[]) new Comparable[elements.length];

		for (int i = lowerBound; i <= upperBound; i++) {
			temp[i] = elements[i];
		}

		int firstPointer = lowerBound;
		int secondPointer = middle + 1;
		int index = lowerBound;

		while (firstPointer <= middle && secondPointer <= upperBound) {
			if (isAscending ? SortUtils.isLess(temp[firstPointer], temp[secondPointer])
					: SortUtils.isGreater(temp[firstPointer], temp[secondPointer])) {
				elements[index] = temp[firstPointer];
				firstPointer++;
			} else {
				elements[index] = temp[secondPointer];
				secondPointer++;
			}
			index++;
		}

		while (firstPointer <= middle) {
			elements[index] = temp[firstPointer];
			index++;
			firstPointer++;
		}

		while (secondPointer <= upperBound) {
			elements[index] = temp[secondPointer];
			index++;
			secondPointer++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.sorting.SortingAlgorithm#sort(java.lang.
	 * Comparable[], boolean)
	 */
	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsortedElements, boolean isAscending) {
		if (unsortedElements == null) {
			throw new IllegalArgumentException("unsortedElements == null");
		}

		int length = unsortedElements.length;

		if (length == 0 || length == 1) {
			return unsortedElements;
		}

		mergeSort(unsortedElements, 0, length - 1, isAscending);
		return unsortedElements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.sorting.SortingAlgorithm#getTimeComplexity(com.
	 * saalamsaifi.datastructure.sorting.TimeComplexity)
	 */
	@Override
	public String getTimeComplexity(TimeComplexity type) {
		String complexity = null;

		if (type == TimeComplexity.BEST || type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			complexity = BigOh.O_N_LOG_N.getComplexity();
		} else {
			complexity = BigOh.O_INVALID.getComplexity();
		}

		return complexity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.sorting.SortingAlgorithm#getSpaceComplexity()
	 */
	@Override
	public String getSpaceComplexity() {
		return BigOh.O_N.getComplexity();
	}
}
