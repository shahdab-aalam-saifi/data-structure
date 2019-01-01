package com.saalamsaifi.datastructure.searching;

import com.saalamsaifi.datastructure.sorting.SortUtils;
import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class BinarySearch implements SearchAlgorithm {

	/**
	 * 
	 */
	private static final int NOT_FOUND = -1;
	private static final int _2 = 2;

	/**
	 * 
	 */
	public BinarySearch() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.searching.SearchAlgorithm#find(java.lang.
	 * Comparable[], java.lang.Comparable)
	 */
	@Override
	public <T extends Comparable<T>> int find(T[] elements, T key) {
		if (elements == null) {
			throw new IllegalArgumentException("elements == null");
		}

		int length = elements.length;

		if (length == 0) {
			return NOT_FOUND;
		}

		int lowerBound = 0;
		int upperBound = length;

		while (true) {
			if (upperBound < lowerBound) {
				return -1;
			}

			int middle = lowerBound + (upperBound - lowerBound) / _2;

			if (SortUtils.isLess(elements[middle].compareTo(key), 0)) {
				lowerBound = middle + 1;
			} else if (elements[middle] == key) {
				return middle;
			} else {
				upperBound = middle - 1;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.searching.SearchAlgorithm#getTimeComplexity(com
	 * .saalamsaifi.datastructure.util.TimeComplexity)
	 */
	@Override
	public String getTimeComplexity(TimeComplexity type) {
		String complexity = null;

		if (type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			complexity = BigOh.O_LOG_N.getComplexity();
		} else {
			complexity = BigOh.O_INVALID.getComplexity();
		}

		return complexity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.searching.SearchAlgorithm#getSpaceComplexity()
	 */
	@Override
	public String getSpaceComplexity() {
		return BigOh.O_1.getComplexity();
	}
}
