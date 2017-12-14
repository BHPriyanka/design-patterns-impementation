package main.java.iterators;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitVectorTests {

	int[] arr;
	BitVector bVector = new BitVector(arr);
	
	// test case to check for parsing the input and checking if 6 is present 
	@Test
	public void test1() {
		int[] input = {0, 1, 4, 7, 31};
		bVector.parseInput(input);

		assertEquals("BitVectorNotSet", bVector.get(6), false);
	}

	
	@Test
	public void testGetForValidElement(){
		int[] input = {0, 1, 4, 7, 31, 44, 67, 90};
		bVector.parseInput(input);

		assertEquals("BitVectorSet", bVector.get(31), true);
	}
	
	// test case to check the set feature of the BitVector class
	@Test
	public void testSetSuccess(){
		int[] input = {0, 1, 4, 7, 31, 44, 67, 90};
		bVector.parseInput(input);

		bVector.set(6);
		assertEquals("BitVectorSet", bVector.get(6), true);
		bVector.clear(6);
		assertEquals("BitVectorClear", bVector.get(6), false);
	}
	
	// test case to check the iterator feature of the BitVector class
	@Test
	public void testIterator(){
		int[] input = {0, 1, 4, 7, 31, 44, 67, 90};
		bVector.parseInput(input);
		Iterator<Integer> it = bVector.iterator();
		if(it.hasAnotherElement()){
			assertEquals(it.nextElement().intValue(), 0);
		}
	}
	
	// test case to check the size feature of the BitVector class
	@Test
	public void testSize(){
		int[] input = {0, 1, 4, 7, 31, 44, 67, 90};
		bVector.parseInput(input);
		assertEquals(bVector.size(),input.length);
	}
	
	
	// test case to check the set feature of the BitVector class for a very large number
	@Test
	public void testSetBitSuccess(){
		int[] input = {0, 1, 4, 7, 31, 44, 67, 90};
		bVector.parseInput(input);

		bVector.set(500);
		assertEquals("BitVectorSet", bVector.get(500), true);
		bVector.clear(500);
		assertEquals("BitVectorClear", bVector.get(500), false);
	}
	
	// test case to check the clear feature of the BitVector class
	@Test
	public void testClearBit(){
		BitVector b = new BitVector(arr);
		b.set(150);
		assertEquals("BitVectorClear", b.get(150), true);	
	}
	
	// test case to check the set feature of the BitVector class for 0th number
	@Test
	public void testSetZeroBit(){
		BitVector b = new BitVector(arr);
		b.set(0);
		assertEquals("BitVectorClear", b.get(0), true);	
	}
	
	// test case to check the addAll feature of the BitVector class
	@Test
	public void testaddAll(){
		int[] a= new int[5];
		BitVector b = new BitVector(a);
		
		int[] arr = {0, 1, 4, 7, 31, 44, 67, 90};
	    b.parseInput(arr);

	    int[] input = {657, 32857, 554};
		b.addAll(new BitVector(input));
		int[] words = b.getWords();
		assertEquals(words.length, 3);
	}
}
