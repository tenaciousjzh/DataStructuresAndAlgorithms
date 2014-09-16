package org.bytescale.datastructures.util.linked;

import org.bytescale.datastructures.spec.linked.UnionFind;

/**
 * Implementation of a data structure that implements the Union find algorithm
 * Steps to Developing a Usable Algorithm
 * 1. Model the problem
 *      Like the Quick Union algorithm, (found in {@link QuickUnionFind}, we'll model this with an array.
 *      However, in this case, the array will represent a set of trees (or forest). Each element 
 *      in the array will contain a reference to its parent in the tree (the index location of the parent).
 *      An effort will be made to balance the tree so no one element is too far from the root.
 *      This is accomplished by putting the smaller tree below the larger one.
 *      Example:
 *      Position: 0	 1	2	3	4	5	6	7	8	9
 *      Value:	  6	 2	6	4	6	6	6	2	4	4
 *      0: Has a parent at location 6
 *      1: Has a parent at location 2
 *      2: Has a parent at location 6
 *      3: Has a parent at location 4
 *      4: Has a parent at location 6
 *      5: Has a parent at location 6
 *      6: Is a stand alone root
 *      7: Has a parent at location 2
 *      8: Has a parent at location 4
 *      9: Has a parent at location 4
 *      We'll add an additional array called sizes to keep track of the number of objects in the tree rooted at i
 * 2. Find an algorithm to solve it
 * 		To initialize, set the id of the object to be the same as its position in the array
 * 		For the find() algorithm, just see if p and q have the same root.
 * 		As an improvement, just after computing the root of an element, p, set the id of each 
 * 		examined node to point to that root. This makes the tree even more shallow and faster to 
 * 		traverse from an element to its root.
 * 
 * 		For the union() algorithm, link the root of the smaller tree to the root of the larger tree.
 * 		Then updated the sizes array. 
 * 
 * 3. Fast Enough? Fits in Memory?
 * 		This improves on Weighted Quick Union by achieving lg * N (That's a funny function that says how many times do we iterated until lg * N = 1)
 * 		If N = 2 ^ 65536 we would iterate only 5 times! This essentially makes performance of this very close to linear time.
 * 		Now, if N = 10^9 (1 billion), this algorithm reduces Quick Find (in {@link QuickFind}) from 30 years to 6 seconds!
 * 4. If not, figure out why.
 * 5. Find a way to address the problem.
 * 6. Iterate until satisfied.
 */
public class WeightedQuickUnionWithPathCompression implements UnionFind {
    //linked trees by index
    private int[] id;
    //num elements under a root (indexed)
    private int[] sizes;
    private int count;

    public WeightedQuickUnionWithPathCompression(int N) {
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

    private int root(int p) {
    	//find the component label
    	//follow the links until you reach the root (no more links up the tree)
    	while (p != id[p]) {
            //This improvement makes the tree more shallow by making every other node in the 
    		//path point to its parent.
            id[p] = id[id[p]];
    		p = id[p];
        }
        return p;
    }
    
    @Override
    public void union(int p, int q) {
        //Give p and q the same parent
        int i = root(p);
        int j = root(q);
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
    	return root(p);
    }

    @Override
    public boolean connected(int p, int q) {
        return (root(p) == root(q));
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
