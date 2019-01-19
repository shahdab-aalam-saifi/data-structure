package com.saalamsaifi.datastructure.linkedlist;

import com.saalamsaifi.datastructure.linkedlist.Node.NodeConstant;
import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructure;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class DoublyLinkedList<T> implements DataStructure, LinkedList<T> {
	private static class DoublyNode<T> extends Node<T> {
		private DoublyNode<T> previous;

		/**
		 * @param value
		 */
		public DoublyNode(T value) {
			super(value);
		}

		/**
		 * @return the previous
		 */
		public DoublyNode<T> getPrevious() {
			return previous;
		}

		/**
		 * @param previous
		 *            the previous to set
		 */
		public void setPrevious(DoublyNode<T> previous) {
			this.previous = previous;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.saalamsaifi.datastructure.linkedlist.Node#getNext()
		 */
		@Override
		public DoublyNode<T> getNext() {
			return (DoublyNode<T>) super.getNext();
		}

	}

	private DoublyNode<T> head;
	private int size;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DoublyLinkedList() {
		super();
		head = new DoublyNode<>((T) new Object());
	}

	/**
	 * @param value
	 */
	public void insertAtHead(T value) {
		DoublyNode<T> newNode = new DoublyNode<>(value);

		if (this.head.getNext() != null) {
			newNode.setNext(this.head.getNext());
			newNode.getNext().setPrevious(newNode);
		}

		this.head.setNext(newNode);
		newNode.setPrevious(this.head);

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

		if (position > this.size()) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			insertAtHead(value);
			return;
		}

		DoublyNode<T> current = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			current = current.getNext();
		}

		DoublyNode<T> newNode = new DoublyNode<>(value);

		newNode.setNext(current.getNext());

		this.incrementSize();

		if (current.getNext() != null) {
			current.getNext().setPrevious(newNode);
		}

		newNode.setPrevious(current);
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
	public DoublyNode<T> deleteAtHead() {
		DoublyNode<T> temp = this.head.getNext();

		if (temp.getNext() != null) {
			this.head.setNext(temp.getNext());
			temp.getNext().setPrevious(this.head);
		} else {
			this.head.setNext(null);
		}

		this.decrementSize();

		return temp;
	}

	/**
	 * @param position
	 * @return
	 */
	public DoublyNode<T> deleteAtNth(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position < 0");
		}

		if (position > this.size()) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			return deleteAtHead();
		}

		DoublyNode<T> first = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			first = first.getNext();
		}

		DoublyNode<T> temp = first.getNext();
		DoublyNode<T> second = temp.getNext();

		first.setNext(second);

		if (second != null) {
			second.setPrevious(first);
		}

		this.decrementSize();

		return temp;
	}

	/**
	 * @return
	 */
	public DoublyNode<T> deleteAtEnd() {
		return deleteAtNth(this.size() - 1);
	}

	/**
	 * @param value
	 * @return
	 */
	public int search(T value) {
		int index = 0;

		DoublyNode<T> current = this.head.getNext();

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

	public int size() {
		return this.size;
	}

	public void printBackward() {
		StringBuilder list = new StringBuilder();

		DoublyNode<T> current = this.head.getNext();

		for (int i = 0; i < this.size() - 1; i++) {
			current = current.getNext();
		}

		list.append(NodeConstant.NULL_NODE.getValue());
		for (int i = 0; i < this.size(); i++) {
			list.append(current);
			current = current.getPrevious();
		}
		list.append(NodeConstant.HEAD_NODE.getValue());

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

		DoublyNode<T> current = this.head.getNext();

		list.append(NodeConstant.HEAD_NODE.getValue());

		while (current != null) {
			list.append(current);
			current = current.getNext();
		}

		list.append(NodeConstant.NULL_NODE.getValue());

		return list.toString();
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
