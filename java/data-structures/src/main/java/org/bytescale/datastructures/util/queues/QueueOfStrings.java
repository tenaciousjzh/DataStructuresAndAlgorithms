package org.bytescale.datastructures.util.queues;

import org.bytescale.datastructures.spec.queues.StringQueue;

public class QueueOfStrings implements StringQueue {
	private Node first;
	private Node last;
	
	public QueueOfStrings() {}
	
	@Override
	public void enqueue(String item) {
		Node oldLast = last;
		last = new Node();
		last.item = "not";
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
	}

	@Override
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	private class Node
	{
		String item;
		Node next;
	}
}
