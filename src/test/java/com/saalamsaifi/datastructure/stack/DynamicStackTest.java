package com.saalamsaifi.datastructure.stack;

import static com.saalamsaifi.datastructure.util.TestProperties.MAX_ELEMENT_COUNT;
import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saalamsaifi.datastructure.util.BigOh;
import com.saalamsaifi.datastructure.util.DataStructureOperation;
import com.saalamsaifi.datastructure.util.TimeComplexity;;

public class DynamicStackTest {
	private DynamicStack<Integer> stack;
	private final PrintStream printStream = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeMethod
	public void setUp() throws Exception {
		stack = new DynamicStack<>();
		System.setOut(new PrintStream(outputStream));
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		outputStream.reset();
		System.setOut(printStream);
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertEquals(stack.isEmpty(), true);
	}

	@Test
	public void testIsNotEmpty() throws Exception {
		stack.push(RandomUtils.nextInt());

		assertEquals(stack.isEmpty(), false);
	}

	@Test
	public void testIsFull() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			stack.push(RandomUtils.nextInt());
		}

		assertEquals(stack.isFull(), false);
	}

	@Test
	public void testIsNotFull() throws Exception {
		stack.push(RandomUtils.nextInt());

		assertEquals(stack.isFull(), false);
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "Stack is empty")
	public void testStackIsEmpty() throws Exception {
		stack.pop();
	}

	@Test
	public void testPushPop() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			stack.push(RandomUtils.nextInt());
		}

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			stack.pop();
		}

		assertEquals(stack.isEmpty(), true);
	}

	@Test
	public void testPeek() throws Exception {
		Integer data = RandomUtils.nextInt();

		stack.push(data);

		assertEquals(stack.peek(), data);
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "Stack is empty")
	public void testEmptyPeek() throws Exception {
		stack.peek();
	}

	@Test
	public void testToString() throws Exception {
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.print(stack);

		assertEquals(outputStream.toString(), "[TOP][4][3][2][1][0][BOTTOM]");
	}

	@Test
	public void testAccessAverageTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchAverageTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionAverageTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionAverageTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testAccessWorstTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchWorstTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionWorstTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionWorstTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testInvalidTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.BEST, DataStructureOperation.ACCESS),
				BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testInvalidOperationTimeComplexity() throws Exception {
		assertEquals(stack.getTimeComplexity(TimeComplexity.WORST, null), BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(stack.getSpaceComplexity(), BigOh.O_N.getComplexity());
	}
}
