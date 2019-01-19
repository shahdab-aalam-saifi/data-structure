package com.saalamsaifi.datastructure.linkedlist;

public class Node<T> {

	public enum NodeConstant {
		HEAD_NODE("(HEAD)"), NULL_NODE("(NULL)");

		private final String value;

		private NodeConstant(final String value) {
			this.value = value;
		}

		/**
		 * @return the name
		 */
		public String getValue() {
			return value;
		}
	}

	private Node<T> next;
	private T value;

	/**
	 * 
	 */
	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the value
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
