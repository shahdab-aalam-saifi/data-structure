package com.saalamsaifi.datastructure.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputUtils {
	private static Random random;

	static {
		random = new Random(System.currentTimeMillis());
	}

	private InputUtils() {
	}

	/**
	 * 
	 * @param bound
	 * @param limit
	 * @return
	 */
	public static List<Integer> integers(int bound, int limit) {
		return Stream.generate(() -> random.nextInt(bound)).limit(limit).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param limit
	 * @return
	 */
	public static List<Float> floats(int limit) {
		return Stream.generate(random::nextFloat).limit(limit).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param limit
	 * @return
	 */
	public static List<Long> longs(int limit) {
		return Stream.generate(random::nextLong).limit(limit).collect(Collectors.toList());
	}

	/**
	 * @param limit
	 * @return
	 */
	public static List<Double> doubles(int limit) {
		return Stream.generate(random::nextDouble).limit(limit).collect(Collectors.toList());
	}
}
