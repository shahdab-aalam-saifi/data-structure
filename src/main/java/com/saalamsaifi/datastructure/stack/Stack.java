package com.saalamsaifi.datastructure.stack;

import com.saalamsaifi.datastructure.util.BasicDatastructure;

public interface Stack<T> extends BasicDatastructure{
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
