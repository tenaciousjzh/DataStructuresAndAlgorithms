package org.bytescale.datastructures.util.stacks;

import org.bytescale.datastructures.spec.stacks.StringStack;

/**
 * Uses a linked list to manage the stack.
 * <p>
 * Every operation takes constant time in the worst case.
 * Uses extra time and space to deal with the links.
 * </p>
 * @author Jared.Holmberg
 *
 */
public class StackOfStrings implements StringStack {
	private Node first = null;

	public StackOfStrings() {
	}
	
	/* (non-Javadoc)
	 * @see org.bytescale.datastructures.spec.stacks.StringStack#push(java.lang.String)
	 */
	@Override
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	/* (non-Javadoc)
	 * @see org.bytescale.datastructures.spec.stacks.StringStack#pop()
	 */
	@Override
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	/* (non-Javadoc)
	 * @see org.bytescale.datastructures.spec.stacks.StringStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	/* (non-Javadoc)
	 * @see org.bytescale.datastructures.spec.stacks.StringStack#size()
	 */
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
	
	private class Node {
		String item;
		Node next;
	} 
}
