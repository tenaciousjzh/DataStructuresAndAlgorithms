package org.bytescale.datastructures.util.bags;

import java.util.Iterator;

import org.bytescale.datastructures.spec.bags.*;

public class StandarBag<T> implements Bag<T> {
	private Node<T> first = null;
	
	@Override
	public Iterator<T> iterator() {
		return new BagIterator();
	}

	@Override
	public void add(T item) {
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldFirst;
	}

	@Override
	public int size() {
		Node node = first;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	private class Node<T> {
		public T item;
		public Node<T> next;
	}

	private class BagIterator implements Iterator<T> {
		private Node<T> current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}
				
	}
}
