package com.saalamsaifi.datastructure.util;

public interface DataStructure {
	/**
	 * @param type
	 * @param operation
	 * @return
	 */
	String getTimeComplexity(TimeComplexity type, DataStructureOperation operation);

	/**
	 * @return
	 */
	String getSpaceComplexity();
}
