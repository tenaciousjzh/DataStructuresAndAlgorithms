package org.bytescale.algorithms.search.clients;

import org.bytescale.algorithms.search.StaticSetOfInts;
import org.bytescale.datastructures.util.In;
import org.bytescale.datastructures.util.StdIn;
import org.bytescale.datastructures.util.StdOut;

public class Whitelist {
	public static void main(String[] args) {
		int[] w = new In(args[0]).readAllInts();
		
		StaticSetOfInts set = new StaticSetOfInts(w);
		while (!StdIn.isEmpty()) {
			//Read the key, print it if not in white list
			int key = StdIn.readInt();
			if (!set.contains(key)) {
				StdOut.println("Sorry the key : " + key + " is not in this set.");
			}
		}
	}
}
