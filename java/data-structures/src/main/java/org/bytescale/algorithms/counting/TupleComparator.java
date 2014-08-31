package org.bytescale.algorithms.counting;

import java.util.Comparator;

public class TupleComparator implements Comparator<Tuple<Integer>> {

    @Override
    public int compare(Tuple<Integer> o1, Tuple<Integer> o2) {
        if (o1.getT1().equals(o2.getT1()) &&
                o1.getT2().equals(o2.getT2()) &&
                o1.getT3().equals(o2.getT3())) {
            return 0;
        } if (o1.getT1() < o2.getT1()) {
            return -1;
        } else if (o1.getT1() > o2.getT1()) {
            return 1;
        }
        return Integer.MIN_VALUE;
    }
}
