package com.saalamsaifi.datastructure.searching;

import com.saalamsaifi.datastructure.util.TimeComplexity;

public interface SearchAlgorithm {
	/**
	 * @param elements
	 * @param key
	 * @return
	 */
	<T extends Comparable<T>> int find(T[] elements, T key);
	
	/**
	 * @param type
	 * @return
	 */
	String getTimeComplexity(TimeComplexity type);
	
	/**
	 * @return
	 */
	String getSpaceComplexity();
}
