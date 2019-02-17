package com.saalamsaifi.datastructure.linkedlist;

import com.saalamsaifi.datastructure.linkedlist.Node.NodeConstant;
import com.saalamsaifi.datastructure.util.DataStructure;

public class SinglyLinkedList<T> implements DataStructure, LinkedList<T> {
	private Node<T> head;
	private int size;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public SinglyLinkedList() {
		head = new Node<>((T) new Object());
	}

	public int size() {
		return this.size;
	}

	/**
	 * 
	 */
	private void incrementSize() {
		this.size++;
	}

	/**
	 * 
	 */
	private void decrementSize() {
		this.size--;
	}

	/**
	 * @param value
	 */
	public void insertAtHead(T value) {
		Node<T> newNode = new Node<>(value);

		if (this.head.getNext() != null) {
			newNode.setNext(this.head.getNext());
		}

		this.head.setNext(newNode);

		this.incrementSize();
	}

	/**
	 * @param value
	 * @param position
	 * @return
	 */
	public void insertAtNth(T value, int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position < 0");
		}

		if (position > this.size) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			insertAtHead(value);
			return;
		}

		Node<T> current = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			current = current.getNext();
		}

		Node<T> newNode = new Node<>(value);
		this.incrementSize();

		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}

	/**
	 * @param value
	 */
	public void insertAtEnd(T value) {
		insertAtNth(value, this.size);
	}

	/**
	 * @return
	 */
	public Node<T> deleteAtHead() {
		Node<T> temp = this.head.getNext();

		this.head.setNext(temp.getNext());

		this.decrementSize();

		return temp;
	}

	/**
	 * @param position
	 * @return
	 */
	public Node<T> deleteAtNth(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position < 0");
		}

		if (position > this.size) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			return deleteAtHead();
		}

		Node<T> first = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			first = first.getNext();
		}

		Node<T> temp = first.getNext();

		first.setNext((first.getNext()).getNext());

		this.decrementSize();

		return temp;
	}

	/**
	 * @return
	 */
	public Node<T> deleteAtEnd() {
		return deleteAtNth(this.size - 1);
	}

	/**
	 * @param value
	 * @return
	 */
	public int search(T value) {
		int index = 0;

		Node<T> current = this.head.getNext();

		if (this.head.getNext() != null) {
			if (current.getValue() == value) {
				return index;
			}

			while (current.getNext() != null) {
				if (current.getValue() == value) {
					return index;
				}
				index++;
				current = current.getNext();
			}
		}

		return -1;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();

		Node<T> current = this.head.getNext();

		list.append(NodeConstant.HEAD_NODE.getValue());

		while (current != null) {
			list.append(current);
			current = current.getNext();
		}

		list.append(NodeConstant.NULL_NODE.getValue());

		return list.toString();
	}
}
