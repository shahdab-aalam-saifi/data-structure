package com.saalamsaifi.datastructure.queue;

import com.saalamsaifi.datastructure.util.BasicDatastructure;

public interface Queue<T> extends BasicDatastructure {
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

}
