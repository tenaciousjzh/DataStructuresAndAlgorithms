package org.bytescale.algorithms.counting;


import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Future;

public class AbstractThreeSum implements ThreeSum {
    protected int flushBufferCount = 10000;
    protected ThreeSumResultsWriter writer;
    protected boolean saveResults = false;

    protected void storeResults(Set<Tuple<Integer>> tuples, Tuple<Integer> integerTuple) {
        tuples.add(integerTuple);
        if (tuples.size() >= flushBufferCount) {
            TreeSet copySet = new TreeSet(new TupleComparator());
            copySet.addAll(tuples);
            writer.writeResults(copySet);
            tuples.clear();
        }
    }

    protected Future<Boolean> storeResults(Set<Tuple<Integer>> tuples, boolean flushRemaining) {
        Future<Boolean> writeFuture = null;
        if (tuples.size() >= flushBufferCount || flushRemaining) {
            TreeSet copySet = new TreeSet(new TupleComparator());
            copySet.addAll(tuples);
            writeFuture = writer.writeResults(copySet);
            tuples.clear();
        }
        return writeFuture;
    }

    @Override
    public int countZeroSumTuples(int[] a) {
        return 0;
    }

    @Override
    public void saveResults(boolean doSave) {
        this.saveResults = doSave;
    }
}
