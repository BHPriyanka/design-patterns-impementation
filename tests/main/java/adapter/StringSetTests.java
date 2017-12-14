package main.java.adapter;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import main.java.iterators.BitVector;
import main.java.iterators.Iterator;

public class StringSetTests {
	int[] arr;
	StringSet stringSet = new StringSet();
	
	// test case to add a string to the StringSet class using add method
	@Test
	public void testGetForInvalidElement() {
		stringSet.add("hello");
		assertEquals(stringSet.size(),1);
	}
	
	// test case to check the remove feature of StringSet class
	@Test
	public void testRemove(){
		stringSet.add("hi");
		assertEquals(stringSet.size(),1);
		stringSet.remove("hello");
		assertEquals(stringSet.size(),1);
		stringSet.remove("hi");
		assertEquals(stringSet.size(),0);
	}

	
	// test case to test the iterator feature of StringSet class
	@Test
	public void testIterator(){
		String[] s = {"hello", "hi", "world"};
		for(int i=0; i<s.length; i++){
			stringSet.add(s[i]);
		}
		
		Iterator<String> it = stringSet.iterator();
		if(it.hasAnotherElement()){
			assertEquals(true, (it.nextElement()).equals("hi"));
		}
	}
	
	
	// test case to validate addAll method of StringSet class
	@Test
	public void testAddAll(){
		String[] s = {"hellos", "hsi", "worsld"};
		for(int i=0; i<s.length; i++){
			stringSet.add(s[i]);
		}
		
		Set<String> s1 = new StringSet();
		s1.add("hello");
		s1.add("hi");
		s1.add("world");
		stringSet.addAll(s1);	
	}
}
