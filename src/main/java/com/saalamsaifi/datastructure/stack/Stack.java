package com.saalamsaifi.datastructure.stack;

public interface Stack<T> {
	/**
	 * @param data
	 */
	void push(T data);

	/**
	 * @return
	 */
	T pop();

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

}
