package com.saalamsaifi.datastructure.stack;

import java.util.ArrayList;

import com.saalamsaifi.datastructure.util.DataStructure;

public class DynamicStack<T> implements Stack<T>, DataStructure {
	private ArrayList<T> stack;
	private int top;

	/**
	 * 
	 */
	public DynamicStack() {
		super();
		this.stack = new ArrayList<>();
		this.top = -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T data) {
		this.stack.add(data);
		this.top++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#pop()
	 */
	@Override
	public T pop() {
		if (this.top >= 0) {
			return this.stack.remove(this.top--);
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
			return this.stack.get(this.top);
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
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.stack.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.top < 0;
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
			builder.append("[" + this.stack.get(i) + "]");
		}
		builder.append(StackConstant.BOTTOM.getValue());

		return builder.toString();
	}

}
