package org.bytescale.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TwoSum {
    /**
     * TwoSum uses a binary search algorithm to find a complement to element(s) in
     * the array provided whose sum is 0. Using binary search elimnates at least one of the
     * for loops found in the ThreeSum algorithm making this O(N * log N) (N from the for loop and log N from Binary search)
     * @param a
     * @return
     */
    public Collection<Pair<Integer>> countZeroSumPairs(int[] a) {
        Arrays.sort(a);
        List<Pair<Integer>> pairs = new ArrayList<Pair<Integer>>();

        int N = a.length;
        for  (int i = 0; i < N; i++) {
            int aI = a[i];
            int j = BinarySearch.rank(-aI, a);
            if (j > i) {
                //we have a number that paired with -a[i] == 0 so collect that
                pairs.add(new Pair<Integer>(aI, a[j]));
            }
        }
        return pairs;
    }
}
