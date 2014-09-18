package org.bytescale.datastructures.util.clients;

import org.bytescale.datastructures.spec.stacks.StackOfStrings;
import org.bytescale.datastructures.spec.stacks.StringStack;
import org.bytescale.datastructures.util.StdIn;
import org.bytescale.datastructures.util.StdOut;

public class StackOfStringsClient {
	public static void main(String[] args) {
		StringStack stack = new StackOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("-")) StdOut.print(stack.pop());
			else stack.push(s);
		}
	}
}
