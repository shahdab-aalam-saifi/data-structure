package com.saalamsaifi.datastructure.stack;

import java.util.ArrayList;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructure;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;

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
		if (this.top >= 0) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stack = new StringBuilder();

		stack.append(StackConstant.TOP.getValue());
		for (int i = this.top; i >= 0; i--) {
			stack.append("[" + this.stack.get(i) + "]");
		}
		stack.append(StackConstant.BOTTOM.getValue());

		return stack.toString();
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
