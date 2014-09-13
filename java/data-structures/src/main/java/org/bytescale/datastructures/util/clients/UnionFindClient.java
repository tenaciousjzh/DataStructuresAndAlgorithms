package org.bytescale.datastructures.util.clients;

import org.bytescale.datastructures.spec.linked.UnionFind;
import org.bytescale.datastructures.util.In;
import org.bytescale.datastructures.util.StdOut;
import org.bytescale.datastructures.util.linked.QuickFind;
import org.bytescale.datastructures.util.linked.WeightedQuickUnion;
import org.bytescale.datastructures.util.linked.WeightedQuickUnionWithPathCompression;

public class UnionFindClient {

	public static void main(String[] args) {
		In input = new In(args[0]);
		int N = input.readInt();
		UnionFind uf = new WeightedQuickUnion(N);
		while (input.hasNextLine()) {
			String line = input.readLine();
			if (line == null || line.equals("")) {
				continue;
			}
			String[] rawInputs = line.split(" ");
			int p = Integer.parseInt(rawInputs[0]);
			int q = Integer.parseInt(rawInputs[1]);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println("Found " + uf.count() + " component groups of connected objects.");
		StdOut.println(uf.toString());
	}
}
