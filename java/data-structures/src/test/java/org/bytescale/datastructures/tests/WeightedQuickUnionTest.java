package org.bytescale.datastructures.tests;

import org.apache.commons.io.FilenameUtils;
import org.bytescale.datastructures.spec.linked.UnionFind;
import org.bytescale.datastructures.tests.util.UnionFindTestDataReader;
import org.bytescale.datastructures.util.linked.QuickUnion;
import org.bytescale.datastructures.util.linked.WeightedQuickUnion;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.assertEquals;


public class WeightedQuickUnionTest {

    @Test
    public void testTinyInput() throws FileNotFoundException {
        URL location = WeightedQuickUnionTest.class.getProtectionDomain().getCodeSource().getLocation();

        UnionFindTestDataReader input = new UnionFindTestDataReader(FilenameUtils.concat(location.getPath(), "quiz-01-quick-find-q02.txt"));
        int N = input.readInt();
        UnionFind uf = new WeightedQuickUnion(N);

        while (false == input.isEmpty()) {
            int p = input.readInt();
            int q = input.readInt();
            if (uf.connected(p, q)) {
                //already connected so skip
                continue;
            }
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " component(s)");
        System.out.println(uf.toString());

        int expectedComponents = 4;
        assertEquals(expectedComponents, uf.count());
    }

}
