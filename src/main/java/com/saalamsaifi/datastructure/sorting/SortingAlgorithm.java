package com.saalamsaifi.datastructure.sorting;

import java.util.Arrays;
import java.util.List;

import com.saalamsaifi.datastructure.util.TimeComplexity;

public interface SortingAlgorithm {
	/**
	 * @param unsortedElements
	 * @param isAscending
	 * @return
	 */
	<T extends Comparable<T>> T[] sort(T[] unsortedElements, boolean isAscending);

	/**
	 * @param type
	 * @return
	 */
	String getTimeComplexity(TimeComplexity type);

	/**
	 * @return
	 */
	String getSpaceComplexity();

	/**
	 * Auxiliary method for algorithms what wanted to work with lists from JCF
	 * 
	 * @param unsorted
	 *            - a list should be sorted
	 * @return a sorted list
	 */
	@SuppressWarnings("unchecked")
	default <T extends Comparable<T>> List<T> sort(List<T> unsortedElements, boolean isAscending) {
		if (unsortedElements == null) {
			throw new IllegalArgumentException("unsortedElements == null");
		}

		int length = unsortedElements.size();

		if (length == 0 || length == 1) {
			return unsortedElements;
		}
		return Arrays
				.asList(sort(unsortedElements.toArray((T[]) new Comparable[unsortedElements.size()]), isAscending));
	}
}
