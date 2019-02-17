package com.saalamsaifi.datastructure.queue;

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

public class StaticQueueTest {
	private StaticQueue<Integer> queue;
	private final PrintStream printStream = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeMethod
	public void setUp() throws Exception {
		queue = new StaticQueue<>(MAX_ELEMENT_COUNT);
		System.setOut(new PrintStream(outputStream));
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		outputStream.reset();
		System.setOut(printStream);
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertEquals(queue.isEmpty(), true);
	}

	@Test
	public void testIsNotEmpty() throws Exception {
		queue.enqueue(RandomUtils.nextInt());

		assertEquals(queue.isEmpty(), false);
	}

	@Test
	public void testIsFull() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			queue.enqueue(RandomUtils.nextInt());
		}

		assertEquals(queue.isFull(), true);
	}

	@Test
	public void testIsNotFull() throws Exception {
		queue.enqueue(RandomUtils.nextInt());

		assertEquals(queue.isFull(), false);
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "Queue is full")
	public void testQueueIsFull() throws Exception {
		for (int i = 0; i <= MAX_ELEMENT_COUNT; i++) {
			queue.enqueue(RandomUtils.nextInt());
		}
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "Queue is empty")
	public void testQueueIsEmpty() throws Exception {
		queue.dequeue();
	}

	@Test
	public void testEnqueueDequeue() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			queue.enqueue(RandomUtils.nextInt());
		}

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			queue.dequeue();
		}

		assertEquals(queue.isEmpty(), true);
	}

	@Test
	public void testPeek() throws Exception {
		Integer data = RandomUtils.nextInt();

		queue.enqueue(data);

		assertEquals(queue.peek(), data);
	}

	@Test(expectedExceptions = {
			UnsupportedOperationException.class }, expectedExceptionsMessageRegExp = "Queue is empty")
	public void testEmptyPeek() throws Exception {
		queue.peek();
	}

	@Test
	public void testToString() throws Exception {
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		System.out.print(queue);

		assertEquals(outputStream.toString(), "[FRONT][0][1][2][3][4][REAR]");
	}

	@Test
	public void testAccessAverageTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchAverageTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionAverageTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionAverageTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testAccessWorstTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchWorstTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionWorstTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionWorstTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testInvalidTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.BEST, DataStructureOperation.ACCESS),
				BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testInvalidOperationTimeComplexity() throws Exception {
		assertEquals(queue.getTimeComplexity(TimeComplexity.WORST, null), BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(queue.getSpaceComplexity(), BigOh.O_N.getComplexity());
	}
}
