package com.saalamsaifi.datastructure.queue;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructure;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public interface Queue<T> extends DataStructure {
	/**
	 * @param data
	 */
	void enqueue(T data);

	/**
	 * @return
	 */
	T dequeue();

	/**
	 * @return
	 */
	T peek();

	/**
	 * @return
	 */
	boolean isFull();

	/**
	 * @return
	 */
	boolean isEmpty();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.util.DataStructure#getTimeComplexity(com.
	 * saalamsaifi.datastructure.util.TimeComplexity,
	 * com.saalamsaifi.datastructure.util.DataStructureOperation)
	 */
	@Override
	public default String getTimeComplexity(TimeComplexity type, DataStructureOperation operation) {
		String complexity = null;

		if (type == TimeComplexity.AVERAGE || type == TimeComplexity.WORST) {
			if (operation == DataStructureOperation.ACCESS || operation == DataStructureOperation.SEARCH) {
				complexity = BigOh.O_N.getComplexity();
			} else if (operation == DataStructureOperation.INSERTION || operation == DataStructureOperation.DELETION) {
				complexity = BigOh.O_1.getComplexity();
			} else {
				complexity = BigOh.O_INVALID.getComplexity();
			}
		} else {
			complexity = BigOh.O_INVALID.getComplexity();
		}

		return complexity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.util.DataStructure#getSpaceComplexity()
	 */
	@Override
	public default String getSpaceComplexity() {
		return BigOh.O_N.getComplexity();
	}

}
