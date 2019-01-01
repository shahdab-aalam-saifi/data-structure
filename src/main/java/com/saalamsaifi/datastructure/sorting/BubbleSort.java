package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class BubbleSort implements SortingAlgorithm {

	/**
	 * 
	 */
	public BubbleSort() {
		super();
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

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (isAscending ? SortUtils.isGreater(unsortedElements[j], unsortedElements[j + 1])
						: SortUtils.isLess(unsortedElements[j], unsortedElements[j + 1])) {
					SortUtils.swap(unsortedElements, j, j + 1);
				}
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
