package com.saalamsaifi.datastructure.queue;

public class StaticQueue<T> implements Queue<T> {
	private int maxSize;
	private int front;
	private int rear;
	private int size;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public StaticQueue(int maxSize) {
		this.maxSize = maxSize;
		this.front = -1;
		this.rear = -1;
		this.size = 0;
		this.queue = (T[]) new Object[this.maxSize];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(T data) {
		if (this.size < this.maxSize) {
			this.rear++;
			this.queue[this.rear % this.maxSize] = data;
			this.size++;

			if (this.front < 0) {
				this.front = 0;
			}
			return;
		}
		throw new UnsupportedOperationException("Queue is full");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#dequeue()
	 */
	@Override
	public T dequeue() {
		if (this.size > 0) {
			T temp = this.queue[this.front];
			this.queue[this.front % this.maxSize] = null;
			this.front++;
			this.size--;
			return temp;
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
		if (this.size > 0) {
			return this.queue[this.front];
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
		return this.maxSize == this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saalamsaifi.datastructure.queue.Queue#isEmpty()
	 */
	@Override
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
		StringBuilder builder = new StringBuilder();

		builder.append(QueueConstant.FRONT.getValue());

		int i = this.front;
		int elementCount = 1;
		while (elementCount <= this.size) {
			i = i % this.maxSize;
			builder.append("[" + this.queue[i] + "]");
			i++;
			elementCount++;
		}

		builder.append(QueueConstant.REAR.getValue());

		return builder.toString();
	}

	}
