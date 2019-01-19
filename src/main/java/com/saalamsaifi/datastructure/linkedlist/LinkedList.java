package com.saalamsaifi.datastructure.linkedlist;

public interface LinkedList<T> {
	void insertAtHead(T value);

	void insertAtNth(T value, int position);

	void insertAtEnd(T value);

	Node<T> deleteAtHead();

	Node<T> deleteAtNth(int position);

	Node<T> deleteAtEnd();

	int size();

	boolean isEmpty();

	int search(T value);
}
