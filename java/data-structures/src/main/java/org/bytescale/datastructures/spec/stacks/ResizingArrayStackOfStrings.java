package org.bytescale.datastructures.spec.stacks;

public class ResizingArrayStackOfStrings implements StringStack {
	private String[] s;
	private int N = 0;
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	@Override
	public void push(String item) {
		if (N == s.length) {
			//By doubling the size of the array 
			//on average, the insertion cost becomes 3N or ~N
			resize(2 * s.length);
		}
		s[N++] = item;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	@Override
	public String pop() {
		String item = s[--N];
		//This prevents "loitering" (orphaned items that were already popped but still on stack
		s[N] = null; 
		if (N > 0 && N == s.length/4) {
			//This shrinks the array to prevent it from becoming too sparse.
			//Halving it when it's one quarter full is a way of 
			//preventing thrashing from frequent push-pop operations.
			resize(s.length/2);
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

}
