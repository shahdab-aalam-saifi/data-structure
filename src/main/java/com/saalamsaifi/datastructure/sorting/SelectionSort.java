package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class SelectionSort implements SortingAlgorithm {

	/**
	 * 
	 */
	public SelectionSort() {
		super();
	}

	/**
	 * @param elements
	 * @param lowerBound
	 * @param order
	 * @return
	 */
	private static <T extends Comparable<T>> int getMinimumLocation(T[] unsortedElements, int lowerBound,
			boolean isAscending) {
		int minimumLocation = lowerBound;
		int length = unsortedElements.length;

		for (int i = minimumLocation + 1; i < length; i++) {
			if (isAscending ? SortUtils.isGreater(unsortedElements[minimumLocation], unsortedElements[i])
					: SortUtils.isLess(unsortedElements[minimumLocation], unsortedElements[i])) {
				minimumLocation = i;
			}
		}

		return minimumLocation;
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

		for (int i = 0; i < length - 1; i++) {
			int minLocation = getMinimumLocation(unsortedElements, i, isAscending);

			if (minLocation != i) {
				SortUtils.swap(unsortedElements, minLocation, i);
			}
		}

		return unsortedElements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.sorting.SortingAlgorithm#getTimeComplexity(com.
	 * saalamsaifi.datastructure.util.TimeComplexity)
	 */
	@Override
	public String getTimeComplexity(TimeComplexity type) {
		String complexity = BigOh.O_INVALID.getComplexity();

		if (type == TimeComplexity.BEST || type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			complexity = BigOh.O_N_2.getComplexity();
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
