package com.saalamsaifi.datastructure.linkedlist;

public interface LinkedList<T> {
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
}
