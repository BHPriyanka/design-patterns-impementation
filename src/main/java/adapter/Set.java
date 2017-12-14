package main.java.adapter;

import main.java.iterators.Iterator;

public interface Set<T> {

	 void add(T t); // add an element to the set 
	 void addAll(Set<T> s); // add all elements in the argument set    
	 void remove(T t); // remove an element from the set  
	 int size(); // return the number of arguments in the set  
	 Iterator<T> iterator(); // return an iterator over the set 
}
