package org.bytescale.algorithms.counting;

import org.bytescale.algorithms.search.BinarySearch;
import org.apache.commons.io.*;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ThreeSumFast extends AbstractThreeSum {

    public ThreeSumFast() {
        URL location = ThreeSumFast.class.getProtectionDomain().getCodeSource().getLocation();
        String fileName = FilenameUtils.concat(location.getPath(),"ThreeSumResults-Fast-" + System.currentTimeMillis() + ".txt");
        writer = new ThreeSumResultsWriter(fileName.substring(1)); //strip the first \
    }


    @Override
    public int countZeroSumTuples(int[] a) {
        Arrays.sort(a);
//        if (containsDuplicates(a)) {
//            throw new IllegalArgumentException("Array must not contain duplicate numbers.");
//        }
        Set<Tuple<Integer>> tuples = new TreeSet<>(new TupleComparator());
        int count = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int aI = a[i];
                int aJ = a[j];
                int k = Arrays.binarySearch(a, -(aI + aJ));
                if (k > j) {
                    if (saveResults) {
                        storeResults(tuples, new Tuple<>(Math.min(aI, aJ),Math.max(aI, aJ),a[k]));
                    }
                    count++;
                }
            }
        }
        if (tuples.size() > 0 && saveResults) {
            boolean flushRemaining = true;
            Future<Boolean> writeFuture = storeResults(tuples, flushRemaining);
            waitToFinishWritingResults(writeFuture);
        }
        return count;
    }

    private void waitToFinishWritingResults(Future<Boolean> writeFuture) {
        try {
            writeFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given a sorted array, this will return true if any duplicate numbers exist
     * @param a
     * @return
     */
    private boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i-1]) {
                return true;
            }
        }
        return false;
    }
}
