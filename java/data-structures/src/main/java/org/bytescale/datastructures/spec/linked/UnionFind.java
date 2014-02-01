package org.bytescale.datastructures.spec.linked;

public interface UnionFind {
    public void union(int p, int q);
    public int find(int p);
    boolean connected(int p, int q);
    int count();
}
