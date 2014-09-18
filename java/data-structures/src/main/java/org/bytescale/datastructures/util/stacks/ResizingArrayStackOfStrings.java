package org.bytescale.datastructures.util.stacks;

import org.bytescale.datastructures.spec.stacks.StringStack;

public class ResizingArrayStackOfStrings implements StringStack {
	private String[] s;
	private int N = 0;
	
	/**
	 * <p>
	 * Memory usage analysis:
	 * 	8 bytes (reference to an array)
	 * 24 bytes (array overhead)
	 *  8 bytes x array size
	 *  4 bytes (int N)
	 *  4 bytes (padding)
	 *  
	 *  Uses between ~8N and ~32N (excluding string values created by client).
	 *  </p>
	 *  <p>
	 *  Every operation takes constant amortized time (over time it average out to constant)
	 *  Less wasted space
	 *  </p>
	 */
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	/**
	 * Average performance is constant (1) with worst case being N because of doubling operation.
	 */
	@Override
	public void push(String item) {
		if (N == s.length) {
			//By doubling the size of the array 
			//on average, the insertion cost becomes 3N or ~N
			resize(2 * s.length);
		}
		s[N++] = item;
	}
	
	/**
	 * 
	 * @param capacity
	 */
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	/**
	 * Average performance is constant (1) with worst case being N because of halving operation
	 */
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

	/**
	 * Average performance is constant (1) with worst case being N 
	 */
	@Override
	public int size() {
		return N;
	}

}
