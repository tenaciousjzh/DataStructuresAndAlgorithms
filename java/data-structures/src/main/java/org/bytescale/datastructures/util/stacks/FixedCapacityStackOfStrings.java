package org.bytescale.datastructures.util.stacks;

import org.bytescale.datastructures.spec.stacks.StringStack;
import org.bytescale.datastructures.util.StdOut;

public class FixedCapacityStackOfStrings implements StringStack {
	private String[] s;
	private int N = 0;
	
	public FixedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		int capacity = s.length;
		int next = N;
		if (next++ >= capacity) {
			StdOut.println("Can't push any more items onto the stack. It has reached its capacity.");
			return;
		}
		s[N++] = item;
	}
	
	public String pop() {
		String item = s[--N];
		//This prevents "loitering" (orphaned items that were already popped but still on stack
		s[N] = null; 
		return item;
	}

	@Override
	public int size() {
		return N;
	}
}
