package com.saalamsaifi.datastructure.linkedlist;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructure;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class DoublyLinkedList<T> implements DataStructure {
	private static final String HEAD_NODE = "(HEAD)";
	private static final String NULL_NODE = "(NULL)";

	private class Node {
		private Node next;
		private Node previous;
		private final T value;

		/**
		 * 
		 */
		public Node(T value) {
			this.value = value;
			length++;
		}

		/**
		 * @return value
		 */
		public T getValue() {
			return this.value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "[" + this.getValue() + "]";
		}
	}

	private Node head;
	private int length;

	/**
	 * 
	 */
	public DoublyLinkedList() {
		head = null;
	}

	public int size() {
		return this.length;
	}

	/**
	 * @param value
	 */
	public void insertAtHead(T value) {
		Node newNode = new Node(value);
		if (this.head != null) {
			newNode.next = this.head;
			this.head.previous = newNode;
		}
		this.head = newNode;
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

		if (position > this.length) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			insertAtHead(value);
			return;
		}

		Node current = this.head;

		for (int i = 0; i < position - 1; i++) {
			current = current.next;
		}

		Node newNode = new Node(value);
		newNode.next = current.next;
		newNode.previous = current;

		if (current.next != null) {
			current.next.previous = newNode;
		}
		current.next = newNode;
	}

	/**
	 * @param value
	 */
	public void insertAtEnd(T value) {
		insertAtNth(value, this.length);
	}

	/**
	 * @return
	 */
	public Node deleteAtHead() {
		Node temp = this.head;

		if (this.head.next != null) {
			this.head = this.head.next;
			this.head.previous = null;
		} else {
			this.head = null;
		}
		this.length--;

		return temp;
	}

	/**
	 * @param position
	 * @return
	 */
	public Node deleteAtNth(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position < 0");
		}

		if (position > this.length) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			return deleteAtHead();
		}

		Node first = this.head;

		for (int i = 0; i < position - 1; i++) {
			first = first.next;
		}

		Node temp = first.next;
		Node second = temp.next;

		first.next = second;
		if (second != null) {
			second.previous = first;
		}

		this.length--;

		return temp;
	}

	/**
	 * @return
	 */
	public Node deleteAtEnd() {
		return deleteAtNth(this.length - 1);
	}

	/**
	 * @param value
	 * @return
	 */
	public int search(T value) {
		int index = 0;

		Node current = this.head;

		if (this.head != null) {
			if (current.getValue() == value) {
				return index;
			}

			while (current.next != null) {
				if (current.getValue() == value) {
					return index;
				}
				index++;
				current = current.next;
			}
		}

		return -1;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return this.length == 0;
	}

	public void printBackward() {
		StringBuilder list = new StringBuilder();

		Node current = this.head;

		for (int i = 0; i < this.length - 1; i++) {
			current = current.next;
		}

		list.append(NULL_NODE);
		for (int i = 0; i < this.length; i++) {
			list.append(current);
			current = current.previous;
		}
		list.append(HEAD_NODE);

		System.out.print(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();

		Node current = this.head;

		list.append(HEAD_NODE);

		while (current != null) {
			list.append(current);
			current = current.next;
		}

		list.append(NULL_NODE);

		return list.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.util.DataStructure#getTimeComplexity(com.
	 * saalamsaifi.datastructure.util.TimeComplexity,
	 * com.saalamsaifi.datastructure.util.DataStructureOperation)
	 */
	@Override
	public String getTimeComplexity(TimeComplexity type, DataStructureOperation operation) {
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
	public String getSpaceComplexity() {
		return BigOh.O_N.getComplexity();
	}
}
