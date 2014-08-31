package org.bytescale.algorithms.counting;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.net.URL;
import java.util.*;

public class ThreeSumBruteForce extends AbstractThreeSum {

    public ThreeSumBruteForce() {
        URL location = ThreeSumBruteForce.class.getProtectionDomain().getCodeSource().getLocation();
        String fileName = FilenameUtils.concat(location.getPath(),"ThreeSumResults-BruteForce-" + System.currentTimeMillis() + ".txt");
        writer = new ThreeSumResultsWriter(fileName.substring(1)); //strip the first \
    }
    /**
     * A brute force attempt at finding a combination of three integers whose sum == 0
     * Performance on this is O(N^3) as it must read each element in the list up to 3 times.
     * This would tend to indicate that this algorithm may only work for smaller data sets.
     * Time to execute is T(N) = aN^3
     * If we try this with 1000 integers in the set, it takes 0.415 milliseconds to execute
     * We can easily solve for a now: T(1000) = a (1000)^3
     * 0.415ms = a (1000^3)
     * a = 0.415ms/(1000^3) = (415 X 10^-12)s
     * So, if we wanted to predict how many seconds it would take to execute on a data set of 1 million integers:
     * T(1,000,000) = (415 * 10^-12) (1,000,000^3) = 415,000,000s which is ~6,916,666m which is ~115,277h!
     * @param a
     * @return
     */
    public int countZeroSumTuples(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        Set<Tuple<Integer>> tuples = new TreeSet<>(new TupleComparator());
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int aI = a[i];
                    int aJ = a[j];
                    int aK = a[k];
                    if (aI + aJ + aK == 0) {
                        if (saveResults) {
                            storeResults(tuples, sortedTuple(aI, aJ, aK));
                        }
                        count++;
                    }
                }
            }
        }
        if (tuples.size() > 0 && saveResults) {
            writer.writeResults(tuples);
        }
        return count;
    }

    private Tuple<Integer> sortedTuple(int aI, int aJ, int aK) {
        int[] tupleA = new int[] {aI, aJ, aK};
        Arrays.sort(tupleA);
        return new Tuple(tupleA[0], tupleA[1], tupleA[2]);
    }
}
