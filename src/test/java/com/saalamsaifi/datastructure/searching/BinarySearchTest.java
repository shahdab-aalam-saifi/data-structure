package com.saalamsaifi.datastructure.searching;

import static com.saalamsaifi.datastructure.sorting.TestProperties.MAX_ELEMENT_COUNT;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;;

public class BinarySearchTest {
	private BinarySearch binarySearch;

	@BeforeClass
	public void setUp() throws Exception {
		binarySearch = new BinarySearch();
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "elements == null")
	public void testNull() throws Exception {
		binarySearch.find(null, null);
	}

	@Test
	public void testEmptyElement() throws Exception {
		Integer[] elements = new Integer[0];
		Integer key = RandomUtils.nextInt();

		Arrays.sort(elements);

		assertEquals(binarySearch.find(elements, key), Arrays.binarySearch(elements, key));
	}

	@Test
	public void testSingleElement() throws Exception {
		Integer[] elements = new Integer[1];
		elements[0] = RandomUtils.nextInt();

		Integer key = elements[0];

		Arrays.sort(elements);

		assertEquals(binarySearch.find(elements, key), Arrays.binarySearch(elements, key));
	}

	@Test
	public void testMultipleElements() throws Exception {
		Integer[] elements = new Integer[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			elements[i] = RandomUtils.nextInt();
		}
		Integer key = elements[RandomUtils.nextInt(MAX_ELEMENT_COUNT)];

		Arrays.sort(elements);

		assertEquals(binarySearch.find(elements, key), Arrays.binarySearch(elements, key));
	}

	@Test
	public void testNegativeElement() throws Exception {
		Integer[] elements = new Integer[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			elements[i] = RandomUtils.nextInt();
		}
		Integer key = RandomUtils.nextInt();

		Arrays.sort(elements);

		assertEquals(binarySearch.find(elements, key), -1);
	}

	@Test
	public void testAverageCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_LOG_N.getComplexity(), binarySearch.getTimeComplexity(TimeComplexity.AVERAGE));
	}

	@Test
	public void testWorstCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_LOG_N.getComplexity(), binarySearch.getTimeComplexity(TimeComplexity.WORST));
	}

	@Test
	public void testInvalidCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_INVALID.getComplexity(), binarySearch.getTimeComplexity(TimeComplexity.BEST));
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(BigOh.O_1.getComplexity(), binarySearch.getSpaceComplexity());
	}
}
