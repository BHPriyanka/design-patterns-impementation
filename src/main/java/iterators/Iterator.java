package main.java.iterators;

// iterator interface used by BitVector and StringSet classes to iterate over elements
public interface Iterator<T> {
	boolean hasAnotherElement();
	T nextElement();
}
