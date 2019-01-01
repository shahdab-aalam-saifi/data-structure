package com.saalamsaifi.datastructure.sorting;

import static com.saalamsaifi.datastructure.sorting.TestProperties.MAX_ELEMENT_COUNT;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class RadixSortTest {
	private RadixSort radixSort;

	@BeforeClass
	public void setUp() throws Exception {
		radixSort = new RadixSort();
	}

	@Test(expectedExceptions = {
			IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "unsortedElements == null")
	public void testNullArray() throws Exception {
		radixSort.sort((int[]) null, true);
	}

	@Test
	public void testEmptyArrayElement() throws Exception {
		int[] unsortedElements = new int[0];

		int[] sortedElements = radixSort.sort(unsortedElements, true);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testSingleArrayElement() throws Exception {
		int[] unsortedElements = new int[1];

		unsortedElements[0] = RandomUtils.nextInt();

		int[] sortedElements = radixSort.sort(unsortedElements, true);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testMultipleElements() throws Exception {
		int[] unsortedElements = new int[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements[i] = RandomUtils.nextInt();
		}

		int[] sortedElements = radixSort.sort(unsortedElements, true);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testDescendingSort() throws Exception {
		int[] unsortedElements = new int[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements[i] = RandomUtils.nextInt();
		}

		int[] sortedElements = radixSort.sort(unsortedElements, false);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "elements cannot be sorted by Radix sort algorithm")
	public void testNegativeNumbers() throws Exception {
		int[] unsortedElements = new int[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements[i] = RandomUtils.nextInt() * -1;
		}

		int[] sortedElements = radixSort.sort(unsortedElements, false);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testBestCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_NK.getComplexity(), radixSort.getTimeComplexity(TimeComplexity.BEST));
	}

	@Test
	public void testAverageCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_NK.getComplexity(), radixSort.getTimeComplexity(TimeComplexity.AVERAGE));
	}

	@Test
	public void testWorstCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_NK.getComplexity(), radixSort.getTimeComplexity(TimeComplexity.WORST));
	}

	@Test
	public void testInvalidCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_INVALID.getComplexity(), radixSort.getTimeComplexity(null));
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(BigOh.O_N_K.getComplexity(), radixSort.getSpaceComplexity());
	}

}
