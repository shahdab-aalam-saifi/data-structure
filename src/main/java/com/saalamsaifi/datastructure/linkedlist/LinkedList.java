package com.saalamsaifi.datastructure.linkedlist;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructure;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public interface LinkedList<T> extends DataStructure {
	/**
	 * @param value
	 */
	void insertAtHead(T value);

	/**
	 * @param value
	 * @param position
	 */
	void insertAtNth(T value, int position);

	/**
	 * @param value
	 */
	void insertAtEnd(T value);

	/**
	 * @return
	 */
	Node<T> deleteAtHead();

	/**
	 * @param position
	 * @return
	 */
	Node<T> deleteAtNth(int position);

	/**
	 * @return
	 */
	Node<T> deleteAtEnd();

	/**
	 * @return
	 */
	int size();

	/**
	 * @return
	 */
	boolean isEmpty();

	/**
	 * @param value
	 * @return
	 */
	int search(T value);
	
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
