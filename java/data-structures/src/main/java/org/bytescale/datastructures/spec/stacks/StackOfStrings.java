package org.bytescale.datastructures.spec.stacks;

public class StackOfStrings {
	private Node first = null;

	public StackOfStrings() {
	}
	
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		Node node = first;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	private class Node {
		String item;
		Node next;
	} 
}
