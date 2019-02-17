package com.saalamsaifi.datastructure.stack;

import com.saalamsaifi.datastructure.util.DataStructure;

public class StaticStack<T> implements Stack<T>, DataStructure {
	private int maxSize;
	private T[] stack;
	private int top;

	@SuppressWarnings("unchecked")
	public StaticStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.stack = (T[]) new Object[this.maxSize];
		this.top = -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T data) {
		if (this.top + 1 < this.maxSize) {
			this.stack[++this.top] = data;
			return;
		}
		throw new UnsupportedOperationException("Stack is overflow");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#pop()
	 */
	@Override
	public T pop() {
		if (this.top >= 0) {
			T temp = this.stack[this.top];
			this.stack[this.top--] = null;
			return temp;
		}
		throw new UnsupportedOperationException("Stack is empty");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#peek()
	 */
	@Override
	public T peek() {
		if (this.top >= 0) {
			return this.stack[this.top];
		}
		throw new UnsupportedOperationException("Stack is empty");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#isFull()
	 */
	@Override
	public boolean isFull() {
		return (this.top + 1) == this.maxSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (this.top + 1) == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(StackConstant.TOP.getValue());
		for (int i = this.top; i >= 0; i--) {
			builder.append("[" + this.stack[i] + "]");
		}
		builder.append(StackConstant.BOTTOM.getValue());

		return builder.toString();
	}
}
