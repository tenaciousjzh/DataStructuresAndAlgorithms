package org.bytescale.algorithms;

import java.util.List;

/**
 * Created by Jared on 1/17/14.
 */
public class QuickSort {
    int[] list;
    public int[] sort(int[] unsortedList) {
        if (unsortedList == null || unsortedList.length == 0) {
            return unsortedList;
        }

        list = unsortedList;
        quickSort(0, list.length - 1);
        return list;
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = list[low + (high-low/2)];

        while (i <= j) {
            while (list[i] < pivot) {
                i++;
            }
            while (list[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j++;
            }

            if (low < j) {
                quickSort(low, j);
            }
            if (i < high) {
                quickSort(i, high);
            }

        }

    }

    private void swap(int i, int j) {
        int temp = list[i];
        list[i] = j;
        list[j] = temp;
    }
}
