package com.saalamsaifi.datastructure.sorting;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class QuickSort implements SortingAlgorithm {
	/**
	 * 
	 */
	public QuickSort() {
		super();
	}

	/***
	 * 
	 * @param unsortedElements
	 * @param lowerBound
	 * @param upperBound
	 * @param order
	 */
	private static <T extends Comparable<T>> void quickSort(T[] unsortedElements, int lowerBound, int upperBound,
			boolean isAscending) {
		if (lowerBound < upperBound) {
			int position = partition(unsortedElements, lowerBound, upperBound, isAscending);
			quickSort(unsortedElements, lowerBound, position - 1, isAscending);
			quickSort(unsortedElements, position, upperBound, isAscending);
		}
	}

	/***
	 * 
	 * @param unsortedElements
	 * @param lowerBound
	 * @param upperBound
	 * @param order
	 * @return
	 */
	private static <T extends Comparable<T>> int partition(T[] unsortedElements, int lowerBound, int upperBound,
			boolean isAscending) {
		T pivot = unsortedElements[lowerBound];

		while (lowerBound <= upperBound) {
			while (isAscending ? SortUtils.isLess(unsortedElements[lowerBound], pivot)
					: SortUtils.isGreater(unsortedElements[lowerBound], pivot)) {
				++lowerBound;
			}
			while (isAscending ? SortUtils.isLess(pivot, unsortedElements[upperBound])
					: SortUtils.isGreater(pivot, unsortedElements[upperBound])) {
				--upperBound;
			}
			if (lowerBound <= upperBound) {
				SortUtils.swap(unsortedElements, lowerBound, upperBound);
				lowerBound++;
				upperBound--;
			}
		}
		return lowerBound;

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

		quickSort(unsortedElements, 0, length - 1, isAscending);

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
		String complexity = null;

		if (type == TimeComplexity.BEST || type == TimeComplexity.AVERAGE) {
			complexity = BigOh.O_N_LOG_N.getComplexity();
		} else if (type == TimeComplexity.WORST) {
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
		return BigOh.O_LOG_N.getComplexity();
	}
}
