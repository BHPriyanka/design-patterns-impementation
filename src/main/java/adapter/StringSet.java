package main.java.adapter;

import java.util.HashMap;
import java.util.Map;
import main.java.iterators.BitVector;
import main.java.iterators.Iterator;

public class StringSet implements Set<String> { 
		
	private Map<String,Integer> mapStringToInt = new HashMap<String,Integer>(); 
	private int[] indices; 
			
	// add a new string as a bit to bitvector,
	// map the string to the index and add the index as a bit in BitVector
	public void add(String s) {
		if(!mapStringToInt.containsKey(s)){
			mapStringToInt.put(s, mapStringToInt.size());
		}
		
		int i=0;
		indices = new int[mapStringToInt.size()];
		for(Map.Entry<String,Integer> entry: mapStringToInt.entrySet()){
			indices[i] = entry.getValue();
			i++;
		}

		adaptee.set(--i);
	}  
	 
	// removes the element from the given array
	public void remove(String s) {
		if(!mapStringToInt.containsKey(s)){
			return;
		}
		
		adaptee.clear(mapStringToInt.get(s));
	} 
	
	// give the size of elements array
	public int size() { 
		return adaptee.size();
	}   
	
	// iterator method to implement the iterator features defined in given interface
	public Iterator<String> iterator(){ 
		return new StringSetIterator(this); 
	} 
	
	int[] arr;
	private BitVector adaptee = new BitVector(arr); 
	
	
	// private inner class for iterator for StringSetVector class
	// so that the class is not visible outside the class
	private class StringSetIterator 
	implements Iterator<String> {
		private String[] list_set_elements;
		private int set_cnt;
		
		StringSetIterator(StringSet b) {
			int i=0;
			list_set_elements = new String[b.size()];
			for(Map.Entry<String,Integer> entry: b.mapStringToInt.entrySet()){
				list_set_elements[i] = entry.getKey();
				i++;
			}
			set_cnt = 0;
		}
			
		public boolean hasAnotherElement(){
			if(set_cnt >= list_set_elements.length){
				return false;
			}
			return true;
		}
			
		public String nextElement(){
			return list_set_elements[set_cnt++];
		}
			
	}
	
	// method to implement the addAll method 
	public void addAll(Set<String> s){ 
		Iterator<String> it = s.iterator();
		while(it.hasAnotherElement()){
			if(!mapStringToInt.containsKey(s)){
				mapStringToInt.put(it.nextElement(), mapStringToInt.size());
			}
		}
		
		int i=0;
		indices = new int[mapStringToInt.size()];
		for(Map.Entry<String,Integer> entry: mapStringToInt.entrySet()){
			indices[i] = entry.getValue();
			i++;
		}
		
		BitVector vector = new BitVector(indices);
		adaptee.addAll(vector);
	}
	
	public Map<String,Integer> getStringSet(){
		return mapStringToInt;
	}
}