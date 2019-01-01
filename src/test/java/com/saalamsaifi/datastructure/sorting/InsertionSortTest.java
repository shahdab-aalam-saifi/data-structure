package com.saalamsaifi.datastructure.sorting;

import static com.saalamsaifi.datastructure.sorting.TestProperties.MAX_ELEMENT_COUNT;
import static com.saalamsaifi.datastructure.sorting.TestProperties.STRING_CHARACTER_COUNT;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;

public class InsertionSortTest {
	private InsertionSort insertionSort;

	@BeforeClass
	public void setUp() throws Exception {
		insertionSort = new InsertionSort();
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "unsortedElements == null")
	public void testNullList() throws Exception {
		insertionSort.sort((List<Integer>) null, true);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "unsortedElements == null")
	public void testNullArray() throws Exception {
		insertionSort.sort((Integer[]) null, true);
	}

	@Test
	public void testEmptyListElement() throws Exception {
		List<Integer> unsortedElements = new ArrayList<>();

		List<Integer> sortedElements = insertionSort.sort(unsortedElements, true);
		Collections.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testEmptyArrayElement() throws Exception {
		Integer[] unsortedElements = new Integer[0];

		Integer[] sortedElements = insertionSort.sort(unsortedElements, true);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	
	@Test
	public void testSingleListElement() throws Exception {
		List<Integer> unsortedElements = new ArrayList<>();

		unsortedElements.add(RandomUtils.nextInt());

		List<Integer> sortedElements = insertionSort.sort(unsortedElements, true);
		Collections.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testSingleArrayElement() throws Exception {
		Integer[] unsortedElements = new Integer[1];

		unsortedElements[0] = RandomUtils.nextInt();

		Integer[] sortedElements = insertionSort.sort(unsortedElements, true);
		Arrays.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	
	@Test
	public void testMultipleElements() throws Exception {
		List<Integer> unsortedElements = new ArrayList<>();

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements.add(RandomUtils.nextInt());
		}

		List<Integer> sortedElements = insertionSort.sort(unsortedElements, true);
		Collections.sort(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}
	
	@Test
	public void testDescendingSort() throws Exception {
		List<Integer> unsortedElements = new ArrayList<>();

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements.add(RandomUtils.nextInt());
		}

		List<Integer> sortedElements = insertionSort.sort(unsortedElements, false);
		Collections.sort(unsortedElements);
		Collections.reverse(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testStringElements() throws Exception {
		List<String> unsortedElements = new ArrayList<>();

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			unsortedElements.add(RandomStringUtils.random(STRING_CHARACTER_COUNT));
		}

		List<String> sortedElements = insertionSort.sort(unsortedElements, false);
		Collections.sort(unsortedElements);
		Collections.reverse(unsortedElements);

		assertEquals(unsortedElements, sortedElements);
	}

	@Test
	public void testBestCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_N.getComplexity(), insertionSort.getTimeComplexity(TimeComplexity.BEST));
	}

	@Test
	public void testAverageCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_N_2.getComplexity(), insertionSort.getTimeComplexity(TimeComplexity.AVERAGE));
	}

	@Test
	public void testWorstCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_N_2.getComplexity(), insertionSort.getTimeComplexity(TimeComplexity.WORST));
	}

	@Test
	public void testInvalidCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_INVALID.getComplexity(), insertionSort.getTimeComplexity(null));
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(BigOh.O_1.getComplexity(), insertionSort.getSpaceComplexity());
	}

}
