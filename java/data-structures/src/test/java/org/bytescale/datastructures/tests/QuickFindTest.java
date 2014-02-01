package org.bytescale.datastructures.tests;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.bytescale.datastructures.spec.linked.UnionFind;
import org.bytescale.datastructures.tests.util.UnionFindTestDataReader;
import org.bytescale.datastructures.util.linked.QuickFind;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.net.URL;


public class QuickFindTest {

    @Test
    public void testTinyInput() throws FileNotFoundException {
        URL location = QuickFindTest.class.getProtectionDomain().getCodeSource().getLocation();

        UnionFindTestDataReader input = new UnionFindTestDataReader(FilenameUtils.concat(location.getPath(),"tinyUF.txt"));
        int N = input.readInt();
        UnionFind uf = new QuickFind(N);
        int numSites = 0;
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

        int expectedComponents = 2;
        assertEquals(expectedComponents, uf.count());
    }

}
