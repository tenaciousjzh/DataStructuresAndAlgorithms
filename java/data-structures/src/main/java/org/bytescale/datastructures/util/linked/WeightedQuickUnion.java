package org.bytescale.datastructures.util.linked;

import org.bytescale.datastructures.spec.linked.UnionFind;

public class WeightedQuickUnion implements UnionFind {
    //linked trees by index
    private int[] id;
    //num elements under a root (indexed)
    private int[] sizes;
    private int count;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sizes = new int[N];
        for (int i = 0; i < N; i++) {
            sizes[i] = 1; //each starts out as single root with no child sites
        }

    }

    @Override
    public void union(int p, int q) {
        //Give p and q the same parent
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        //make the root with smaller size go under the larger one
        if (sizes[i] < sizes[j]) {
            id[i] = j;
            //more sites added under root j so increase its size
            sizes[j] += sizes[i];
        } else {
            id[j] = i;
            //more sites added under root i so increase its size
            sizes[i] += sizes[j];
        }
        count--;
    }

    @Override
    public int find(int p) {
        //find the component label
        while (p != id[p]) {
            //follow the links until you reach the root (no more links up the tree)
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String newLine = System.getProperty("line.separator");

        for (int i = 0; i < id.length; i++) {
            sb.append("id[" + i + "] = " + id[i] + newLine);
        }

        sb.append(newLine);
        for (int j = 0; j < sizes.length; j++) {
            sb.append("sizes[" + j + "] = " + sizes[j] + newLine);
        }
        return sb.toString();
    }
}
