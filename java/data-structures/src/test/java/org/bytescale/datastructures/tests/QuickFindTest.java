package org.bytescale.datastructures.tests;

import org.apache.commons.io.FilenameUtils;
import org.bytescale.datastructures.spec.linked.UnionFind;
import org.bytescale.datastructures.tests.util.UnionFindTestDataReader;
import org.bytescale.datastructures.util.linked.BasicUnionFind;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.net.URL;


public class QuickFindTest {

    @Test
    public void testTinyInput() throws FileNotFoundException {
        URL location = QuickFindTest.class.getProtectionDomain().getCodeSource().getLocation();

        UnionFindTestDataReader input = new UnionFindTestDataReader(FilenameUtils.concat(location.getPath(), "quiz-01-quick-find-q01.txt"));
        int N = input.readInt();
        UnionFind uf = new BasicUnionFind(N);

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

        int expectedComponents = 4;
        assertEquals(expectedComponents, uf.count());
    }

}
