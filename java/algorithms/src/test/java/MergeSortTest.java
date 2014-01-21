import org.bytescale.algorithms.MergeSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testSort() {
        MergeSort<Integer> sorter = new MergeSort<Integer>();
        List<Integer> unsorted = new ArrayList<Integer>(10);
        unsorted.add(-11);
        unsorted.add(3);
        unsorted.add(1);
        unsorted.add(-2);
        unsorted.add(78);
        unsorted.add(22);
        unsorted.add(-1000);
        unsorted.add(-1000);
        unsorted.add(0);
        unsorted.add(42);

        List<Integer> sorted = sorter.sort(unsorted);

        List<Integer> expectedSort = new ArrayList<Integer>(10);
        expectedSort.add(-1000);
        expectedSort.add(-1000);
        expectedSort.add(-11);
        expectedSort.add(-2);
        expectedSort.add(0);
        expectedSort.add(1);
        expectedSort.add(3);
        expectedSort.add(22);
        expectedSort.add(42);
        expectedSort.add(78);

        for (int i = 0; i < expectedSort.size(); i++) {
            assertEquals(expectedSort.get(i), sorted.get(i));
        }

    }
}
