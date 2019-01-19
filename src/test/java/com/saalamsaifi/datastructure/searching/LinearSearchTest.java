package com.saalamsaifi.datastructure.searching;

import static com.saalamsaifi.datastructure.util.TestProperties.MAX_ELEMENT_COUNT;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.TimeComplexity;;

public class LinearSearchTest {
	private LinearSearch linearSearch;

	@BeforeClass
	public void setUp() throws Exception {
		linearSearch = new LinearSearch();
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "elements == null")
	public void testNull() throws Exception {
		linearSearch.find(null, null);
	}

	@Test
	public void testEmptyElement() throws Exception {
		Integer[] elements = new Integer[0];
		Integer key = RandomUtils.nextInt();

		assertEquals(linearSearch.find(elements, key), Arrays.binarySearch(elements, key));
	}

	@Test
	public void testSingleElement() throws Exception {
		Integer[] elements = new Integer[1];
		elements[0] = RandomUtils.nextInt();

		Integer key = elements[0];

		assertEquals(linearSearch.find(elements, key), Arrays.binarySearch(elements, key));
	}

	@Test
	public void testMultipleElements() throws Exception {
		Integer[] elements = new Integer[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			elements[i] = RandomUtils.nextInt();
		}
		Integer key = elements[RandomUtils.nextInt(MAX_ELEMENT_COUNT)];

		int index = linearSearch.find(elements, key);
		assertEquals(elements[index], key);
	}

	@Test
	public void testNegativeElement() throws Exception {
		Integer[] elements = new Integer[MAX_ELEMENT_COUNT];

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			elements[i] = RandomUtils.nextInt();
		}
		Integer key = RandomUtils.nextInt();

		assertEquals(linearSearch.find(elements, key), -1);
	}

	@Test
	public void testAverageCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_N.getComplexity(), linearSearch.getTimeComplexity(TimeComplexity.AVERAGE));
	}

	@Test
	public void testWorstCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_N.getComplexity(), linearSearch.getTimeComplexity(TimeComplexity.WORST));
	}

	@Test
	public void testInvalidCaseTimeComplexity() throws Exception {
		assertEquals(BigOh.O_INVALID.getComplexity(), linearSearch.getTimeComplexity(TimeComplexity.BEST));
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(BigOh.O_1.getComplexity(), linearSearch.getSpaceComplexity());
	}
}
