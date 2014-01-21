package org.bytescale.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable <? super T>> {

    public List<T> sort(List<T> unsortedList) {
        if (unsortedList == null) {
            throw new IllegalArgumentException("Unable to sort a null valued list.");
        }
        if (unsortedList.size() <= 1) {
            //This is a base case. A list of zero or 1 elements is sorted by definition
            return unsortedList;
        }

        //Recursive case. Divide the list into equal sized sublists
        int middle =  unsortedList.size() / 2;
        List<T> left = new ArrayList<T>(middle),
                right = new ArrayList<T>(middle);
        for (int i = 0; i < middle; i++) {
            left.add(unsortedList.get(i));
        }

        for (int j = middle; j < unsortedList.size(); j++) {
            right.add(unsortedList.get(j));
        }

        //Sort the sublists
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<T>(right.size());

        while (left.size() > 0 || right.size() > 0) {
            T firstLeft = left.get(0);
            T firstRight = right.get(0);

            if (left.size() > 0 && right.size() > 0) {
                //the smaller value is copied to the result list
                if (leftIsLessThanOrEqualToRight(firstLeft, firstRight)) {
                    result.add(firstLeft);
                    left.remove(0);
                } else {
                     result.add(firstRight);
                    right.remove(0);
                }

            } else if (left.size() > 0) {
                //on each iteration, copy the remaining elements from the sublist to the result
                result.add(firstLeft);
                left.remove(0);
            } else if (right.size() > 0) {
                //on each iteration, copy the remaining elements from the sublist to the result
                result.add(firstRight);
                right.remove(0);
            }
        }
        return result;
    }

    private boolean leftIsLessThanOrEqualToRight(T left, T right) {
        if (left.compareTo(right) <= 0) {
            return true;
        }
        return false;
    }



}
