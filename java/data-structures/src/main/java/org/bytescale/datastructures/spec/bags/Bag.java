package org.bytescale.datastructures.spec.bags;

public interface Bag<T> extends Iterable<T> {
	void add(T item);
	int size();
}
