package org.bytescale.datastructures.util.linked;

import org.bytescale.datastructures.spec.linked.UnionFind;

/**
 * Implementation of a data structure that implements the Union find algorithm
 * Steps to Developing a Usable Algorithm
 * 1. Model the problem
 *      If we give each object a label to a number, that makes it easy to model any number of
 *      objects in a generic way. Plus, it allows us to index the objects into an array very easily.
 * 2. Find an algorithm to solve it
 * 3. Fast Enough? Fits in Memory?
 *      This version works with small data sets but the performance is not so good for medium to large sets.
 *      For instance, if we ran this with a data set that ends up with 1 component, that means it had to access the id[]
 *      N-1 times. Each time it calls
 * 4. If not, figure out why.
 * 5. Find a way to address the problem.
 * 6. Iterate until satisfied.
 */
public class QuickFind implements UnionFind {

    private int[] id;
    private int count;

    /**
     * Initializes sites (objects) with labels (0 through N-1)
     * @param N
     */
    public QuickFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Add a connection between p and q
     * Performance here is N+3 (3 index lookups = connected(p, q) turns into (id[p] + id[q]) + (id[i] == pID) )
     * + a full iteration of the array each time union() is called (N))
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        //Put p and q into the same component
        //Nothing to do if p and q are in same component already
        if (connected(p,q)) {
            return;
        }
        int pID = find(p);
        //Change the values from id[p] to id[q]
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = id[q];
            }
        }
        count--; //We've combined two components so decrement count by 1
    }

    /**
     * Component identifier for p (0 to N-1)
     * Performance with this implementation of find() is O(1) since it does a single index lookup
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        return id[p];
    }

    /**
     * Returns true if p and q are in the same component.
     * Performance is O(1) with two array accesses
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }

    /**
     * Returns the number of components
     * @return
     */
    @Override
    public int count() {
        return count;
    }
}
