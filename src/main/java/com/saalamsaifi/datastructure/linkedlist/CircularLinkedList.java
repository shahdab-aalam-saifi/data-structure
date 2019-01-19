package com.saalamsaifi.datastructure.linkedlist;

import com.saalamsaifi.datastructure.linkedlist.Node.NodeConstant;

public class CircularLinkedList<T> implements LinkedList<T> {
	private CircularNode<T> head;
	private int size;

	private static class CircularNode<T> extends Node<T> {
		private CircularNode<T> previous;

		/**
		 * @param value
		 */
		public CircularNode(T value) {
			super(value);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.saalamsaifi.datastructure.linkedlist.Node#getNext()
		 */
		@Override
		public CircularNode<T> getNext() {
			return (CircularNode<T>) super.getNext();
		}
	}

	@SuppressWarnings("unchecked")
	public CircularLinkedList() {
		super();
		this.head = new CircularNode<>((T) new Object());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.linkedlist.LinkedList#insertAtHead(java.lang.
	 * Object)
	 */
	@Override
	public void insertAtHead(T value) {
		CircularNode<T> newNode = new CircularNode<>(value);

		if (this.head.getNext() == null) {
			this.head.setNext(newNode);
			newNode.previous = this.head;
			newNode.setNext(this.head);
			head.previous = newNode;
		} else {
			newNode.setNext(this.head.getNext());
			newNode.getNext().previous = newNode;
			this.head.setNext(newNode);
			newNode.previous = this.head;
		}

		this.incrementSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.linkedlist.LinkedList#insertAtNth(java.lang.
	 * Object, int)
	 */
	@Override
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

		if (position == this.size) {
			insertAtEnd(value);
			return;
		}

		CircularNode<T> current = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			current = current.getNext();
		}

		CircularNode<T> newNode = new CircularNode<>(value);

		newNode.setNext(current.getNext());
		if (newNode.getNext() != null) {
			newNode.getNext().previous = newNode;
		}

		current.setNext(newNode);
		newNode.previous = current;

		CircularNode<T> endNode = goToEnd();
		if (endNode != null) {
			endNode.setNext(this.head);
			this.head.previous = endNode;
		}

		this.incrementSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.linkedlist.LinkedList#insertAtEnd(java.lang.
	 * Object)
	 */
	@Override
	public void insertAtEnd(T value) {
		CircularNode<T> newNode = new CircularNode<>(value);

		if (this.head.getNext() == null) {
			this.head.setNext(newNode);
			newNode.previous = this.head;
			newNode.setNext(this.head);
			head.previous = newNode;
		} else {
			CircularNode<T> current = this.head.getNext();

			while (current.getNext() != this.head) {
				current = current.getNext();
			}

			current.setNext(newNode);
			newNode.previous = current;
			newNode.setNext(this.head);
			this.head.previous = newNode;
		}

		this.incrementSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.linkedlist.LinkedList#deleteAtHead()
	 */
	@Override
	public Node<T> deleteAtHead() {
		CircularNode<T> temp = this.head.getNext();

		if (temp != null) {
			if (temp.getNext() != this.head) {
				this.head.setNext(temp.getNext());
				temp.getNext().previous = this.head;
			} else {
				this.head.setNext(null);
				this.head.previous = null;
				temp.setNext(null);
				temp.previous = null;
			}
		}

		this.decrementSize();
		return temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.linkedlist.LinkedList#deleteAtNth(int)
	 */
	@Override
	public Node<T> deleteAtNth(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position < 0");
		}

		if (position > this.size()) {
			throw new IllegalArgumentException("position > size");
		}

		if (position == 0) {
			return deleteAtHead();
		}

		if (position == this.size - 1) {
			return deleteAtEnd();
		}

		CircularNode<T> first = this.head.getNext();

		for (int i = 0; i < position - 1; i++) {
			first = first.getNext();
		}

		CircularNode<T> temp = first.getNext();
		CircularNode<T> second = temp.getNext();

		first.setNext(second);
		second.previous = first;

		this.decrementSize();
		return temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.linkedlist.LinkedList#deleteAtEnd()
	 */
	@Override
	public Node<T> deleteAtEnd() {
		if (this.head.getNext() != null) {
			CircularNode<T> temp = this.head.getNext();

			while (temp.getNext() != this.head) {
				temp = temp.getNext();
			}

			temp.previous.setNext(this.head);
			this.head.previous = temp.previous;

			temp.setNext(null);
			temp.previous = null;

			this.decrementSize();
			return temp;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.linkedlist.LinkedList#size()
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.linkedlist.LinkedList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saalamsaifi.datastructure.linkedlist.LinkedList#search(java.lang.Object)
	 */
	@Override
	public int search(T value) {
		int index = 0;

		CircularNode<T> current = this.head.getNext();

		if (this.head.getNext() != null) {
			if (current.getValue() == value) {
				return index;
			}

			while (current.getNext() != this.head) {
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
	private void incrementSize() {
		this.size++;
	}

	/**
	 * @param length
	 */
	private void decrementSize() {
		this.size--;
	}

	private CircularNode<T> goToEnd() {
		CircularNode<T> end = this.head.getNext();

		while (end != null && end.getNext() != this.head) {
			end = end.getNext();
		}

		return end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();

		CircularNode<T> current = this.head.getNext();

		list.append(NodeConstant.HEAD_NODE.getValue());

		while (current != null && current != this.head) {
			list.append(current);
			current = current.getNext();
		}

		list.append(NodeConstant.NULL_NODE.getValue());

		return list.toString();
	}

	/**
	 * 
	 */
	public void printBackward() {
		StringBuilder list = new StringBuilder();

		CircularNode<T> current = this.head.previous;

		list.append(NodeConstant.NULL_NODE.getValue());

		while (current != null && current != this.head) {
			list.append(current);
			current = current.previous;
		}

		list.append(NodeConstant.HEAD_NODE.getValue());

		System.out.print(list.toString());
	}
}
