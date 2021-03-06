package com.saalamsaifi.datastructure.stack;

public enum StackConstant {
	TOP("[TOP]"), BOTTOM("[BOTTOM]");

	private String value;

	/**
	 * @param value
	 */
	private StackConstant(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
