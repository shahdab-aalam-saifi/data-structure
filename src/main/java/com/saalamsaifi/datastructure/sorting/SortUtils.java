package com.saalamsaifi.datastructure.sorting;

public final class SortUtils {
	/**
	 * 
	 */
	private SortUtils() {

	}

	/**
	 * 
	 * @param elements
	 * @param firstElement
	 * @param secondElement
	 * @return
	 */
	public static <T extends Comparable<T>> boolean swap(T[] elements, int firstElement, int secondElement) {
		T temp = elements[firstElement];
		elements[firstElement] = elements[secondElement];
		elements[secondElement] = temp;
		return true;
	}

	/**
	 * 
	 * @param firstElement
	 * @param secondElement
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isLess(T firstElement, T secondElement) {
		return firstElement.compareTo(secondElement) < 0;
	}

	/**
	 * 
	 * @param firstElement
	 * @param secondElement
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isGreater(T firstElement, T secondElement) {
		return firstElement.compareTo(secondElement) > 0;
	}
}
