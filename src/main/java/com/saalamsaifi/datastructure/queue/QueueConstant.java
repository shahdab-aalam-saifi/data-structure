package com.saalamsaifi.datastructure.queue;

public enum QueueConstant {
	FRONT("[FRONT]"), REAR("[REAR]");

	private String value;

	/**
	 * @param value
	 */
	private QueueConstant(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
