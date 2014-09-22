package org.bytescale.datastructures.spec.queues;

public interface StringQueue {
	void enqueue(String item);
	String dequeue();
	boolean isEmpty();
}
