package org.bytescale.datastructures.util.linked;

import org.bytescale.datastructures.spec.linked.UnionFind;

/**
 * Implementation of a data structure that implements the Union find algorithm
 * Steps to Developing a Usable Algorithm
 * 1. Model the problem
 *      Like the Quick Find (found in {@link BasicUnionFind}, we'll model this with an array.
 *      However, in this case, the array will represent a set of trees (or forest). Each element 
 *      in the array will contain a reference to its parent in the tree (the index location of the parent).
 *      Example:
 *      Position: 0	 1	2	3	4	5	6	7	8	9
 *      Value:	  0	 1	9	4	9	6	6	7	8	9
 *      0: is a stand alone root
 *      1: is a stand alone root
 *      2: Has a parent at location 9
 *      3: Has a parent at location 4
 *      4: Has a parent at location 9
 *      5: Has a parent at location 6
 *      6: Is a stand alone root
 *      7: Is a stand alone root
 *      8: Is a stand alone root
 *      9: Is a stand alone root
 * 2. Find an algorithm to solve it
 * 		To initialize, set the id of the object to be the same as its position in the array
 * 		For the find() algorithm, just see if p and q have the same root
 * 		For the union() algorithm, to merge components, set the id of p's root, to the id of q's root
 * 
 * 3. Fast Enough? Fits in Memory?
 *      Cost for this Model:
 *      To initialize each object, the array must be iterated N times.
 *      In the find algorithm, worst case could be N times
 * 4. If not, figure out why.
 * 		Trees could get really tall forcing find()/root() to access the array N times.
 * 5. Find a way to address the problem.
 * 6. Iterate until satisfied.
 */
public class QuickUnionFind implements UnionFind {
    private int[] id;
    private int count;

    //Performance of N array accesses
    public QuickUnionFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    
    private int root(int i) {
    	//i is a copy of the original value passed in, 
    	//but will be modified to be the parent once that is found
    	while (i != id[i]) {
    		//follow the links until you reach the root (no more links up the tree)
    		i = id[i];
    	}
    	return i;
    }

    /**
     * Change the root of p to point to the root of q
     */
    @Override
    public void union(int p, int q) {
        //Give p and q the same parent
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        id[i] = j;
        count--;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    /**
     * Objects p and q are connected if they share the same root (also called parent)
     */
    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
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
