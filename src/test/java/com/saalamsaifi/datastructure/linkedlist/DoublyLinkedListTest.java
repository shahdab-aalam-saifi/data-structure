package com.saalamsaifi.datastructure.linkedlist;

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

public class DoublyLinkedListTest {
	private DoublyLinkedList<Integer> linkedList;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private final PrintStream printStream = System.out;

	@BeforeMethod
	public void setUp() throws Exception {
		linkedList = new DoublyLinkedList<>();
		System.setOut(new PrintStream(outputStream));
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		outputStream.reset();
		System.setOut(printStream);
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertEquals(linkedList.isEmpty(), true);
	}

	@Test
	public void testNotIsEmpty() throws Exception {
		linkedList.insertAtHead(RandomUtils.nextInt());
		assertEquals(linkedList.isEmpty(), false);
	}

	@Test
	public void testInsertAtHead() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtHead(RandomUtils.nextInt());
		}

		assertEquals(linkedList.size(), MAX_ELEMENT_COUNT);
	}

	@Test
	public void testInsertAtNth() throws Exception {
		linkedList.insertAtNth(RandomUtils.nextInt(), 0);

		for (int i = 1; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtNth(RandomUtils.nextInt(), RandomUtils.nextInt(linkedList.size() + 1));
		}

		assertEquals(linkedList.size(), MAX_ELEMENT_COUNT);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "position < 0")
	public void testInsertBeforeHead() throws Exception {
		linkedList.insertAtNth(RandomUtils.nextInt(), -1);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "position > size")
	public void testInsertAfterEnd() throws Exception {
		linkedList.insertAtNth(RandomUtils.nextInt(), linkedList.size() + 1);
	}

	@Test
	public void testInsertAtEnd() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtEnd(RandomUtils.nextInt());
		}

		assertEquals(linkedList.size(), MAX_ELEMENT_COUNT);
	}

	@Test
	public void testDeleteAtHead() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtHead(RandomUtils.nextInt());
			linkedList.deleteAtHead();
		}

		assertEquals(linkedList.size(), 0);
	}

	@Test
	public void testDeleteAtNth() throws Exception {
		linkedList.insertAtNth(RandomUtils.nextInt(), 0);
		for (int i = 1; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtNth(RandomUtils.nextInt(), RandomUtils.nextInt(linkedList.size() + 1));
		}

		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.deleteAtNth(RandomUtils.nextInt(linkedList.size()));
		}

		assertEquals(linkedList.size(), 0);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "position < 0")
	public void testDeleteBeforeHead() throws Exception {
		linkedList.deleteAtNth(-1);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "position > size")
	public void testDeleteAfterEnd() throws Exception {
		linkedList.deleteAtNth(linkedList.size() + 1);
	}

	@Test
	public void testDeleteAtEnd() throws Exception {
		for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
			linkedList.insertAtEnd(RandomUtils.nextInt());
			linkedList.deleteAtEnd();
		}

		assertEquals(linkedList.size(), 0);
	}

	@Test
	public void testSearchHeadIsNull() throws Exception {
		assertEquals(linkedList.search(RandomUtils.nextInt(MAX_ELEMENT_COUNT)), -1);
	}

	@Test
	public void testSearchElementAtHead() throws Exception {
		int value = RandomUtils.nextInt(MAX_ELEMENT_COUNT);
		linkedList.insertAtHead(value);

		int index = linkedList.search(value);
		assertEquals(index >= 0, true);
	}

	@Test
	public void testSearch() throws Exception {
		int value = RandomUtils.nextInt(MAX_ELEMENT_COUNT);
		linkedList.insertAtNth(RandomUtils.nextInt(MAX_ELEMENT_COUNT), 0);
		linkedList.insertAtNth(RandomUtils.nextInt(MAX_ELEMENT_COUNT), 1);
		linkedList.insertAtNth(value, 2);
		linkedList.insertAtNth(RandomUtils.nextInt(MAX_ELEMENT_COUNT), 3);
		linkedList.insertAtNth(RandomUtils.nextInt(MAX_ELEMENT_COUNT), 4);

		int index = linkedList.search(value);
		assertEquals(index >= 0, true);
	}

	@Test
	public void testNotFound() throws Exception {
		int value = RandomUtils.nextInt(MAX_ELEMENT_COUNT);
		linkedList.insertAtNth(value, 0);

		int index = linkedList.search(value * -1);
		assertEquals(index, -1);
	}

	@Test
	public void testNodeToString() throws Exception {
		int value = RandomUtils.nextInt();

		linkedList.insertAtHead(value);
		System.out.print(linkedList);

		assertEquals("(HEAD)[" + value + "](NULL)", outputStream.toString());
	}

	@Test
	public void testPrintBackword() throws Exception {
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.printBackward();

		assertEquals(linkedList.printBackward(), "(NULL)[5][4][3][2][1](HEAD)");
	}

	@Test
	public void testAccessAverageTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchAverageTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionAverageTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionAverageTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.AVERAGE, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testAccessWorstTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.ACCESS),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testSearchWorstTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.SEARCH),
				BigOh.O_N.getComplexity());
	}

	@Test
	public void testInsertionWorstTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.INSERTION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testDeletionWorstTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.WORST, DataStructureOperation.DELETION),
				BigOh.O_1.getComplexity());
	}

	@Test
	public void testInvalidTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.BEST, DataStructureOperation.ACCESS),
				BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testInvalidOperationTimeComplexity() throws Exception {
		assertEquals(linkedList.getTimeComplexity(TimeComplexity.WORST, null), BigOh.O_INVALID.getComplexity());
	}

	@Test
	public void testSpaceComplexity() throws Exception {
		assertEquals(linkedList.getSpaceComplexity(), BigOh.O_N.getComplexity());
	}

}
