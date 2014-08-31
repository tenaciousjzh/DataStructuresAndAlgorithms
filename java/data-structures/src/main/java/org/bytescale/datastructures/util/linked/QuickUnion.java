package org.bytescale.datastructures.util.linked;

import org.bytescale.datastructures.spec.linked.UnionFind;

public class QuickUnion implements UnionFind {
    private int[] id;
    private int count;

    public QuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
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
        id[i] = j;
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
        return sb.toString();
    }
}
