package com.saalamsaifi.datastructure.util;

public enum BigOh {
	O_LOG_N("O (log n)"), O_1("O (1)"), O_N("O (n)"), O_N_LOG_N("O (n log(n))"), O_N_2("O (n^2)"), O_2_N(
			"O (2^N)"), O_N_F("O (n!)"), O_NK("O (nk)"), O_N_K("O (n+k)"), O_INVALID("O (#)");

	private final String complexity;

	BigOh(final String complexity) {
		this.complexity = complexity;
	}

	/**
	 * @return the complexity
	 */
	public String getComplexity() {
		return this.complexity;
	}
}
