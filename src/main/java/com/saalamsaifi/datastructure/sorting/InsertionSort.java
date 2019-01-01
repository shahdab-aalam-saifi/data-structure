package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class InsertionSort implements SortingAlgorithm {
	/**
	 * 
	 */
	public InsertionSort() {
		super();
	}

	/**
	 * @param elements
	 * @param index
	 * @param isAscending
	 * @return
	 */
	private static <T extends Comparable<T>> boolean isRequireSorting(T[] elements, int index, boolean isAscending) {
		return isAscending ? SortUtils.isLess(elements[index], elements[index - 1])
				: SortUtils.isGreater(elements[index], elements[index - 1]);
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

		for (int i = 1; i < length; i++) {
			if (isRequireSorting(unsortedElements, i, isAscending)) {
				T nextElement = unsortedElements[i];
				int position = i;

				while (position > 0 && (isAscending ? SortUtils.isLess(nextElement, unsortedElements[position - 1])
						: SortUtils.isGreater(nextElement, unsortedElements[position - 1]))) {
					unsortedElements[position] = unsortedElements[position - 1];
					position--;
				}
				unsortedElements[position] = nextElement;
			}
		}

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

		if (type == TimeComplexity.BEST) {
			complexity = BigOh.O_N.getComplexity();
		} else if (type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			complexity = BigOh.O_N_2.getComplexity();
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
		return BigOh.O_1.getComplexity();
	}
}
