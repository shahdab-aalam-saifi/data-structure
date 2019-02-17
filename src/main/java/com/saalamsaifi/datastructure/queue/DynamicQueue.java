package com.saalamsaifi.datastructure.queue;

import java.util.ArrayList;

public class DynamicQueue<T> implements Queue<T> {
	private ArrayList<T> queue;

	public DynamicQueue() {
		this.queue = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(T data) {
		this.queue.add(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#dequeue()
	 */
	@Override
	public T dequeue() {
		if (!this.queue.isEmpty()) {
			return this.queue.remove(0);
		}
		throw new UnsupportedOperationException("Queue is empty");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#peek()
	 */
	@Override
	public T peek() {
		if (!this.queue.isEmpty()) {
			return this.queue.get(0);
		}
		throw new UnsupportedOperationException("Queue is empty");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(QueueConstant.FRONT.getValue());

		for (int i = 0; i < this.queue.size(); i++) {
			builder.append("[" + this.queue.get(i) + "]");

		}

		builder.append(QueueConstant.REAR.getValue());

		return builder.toString();
	}
}
