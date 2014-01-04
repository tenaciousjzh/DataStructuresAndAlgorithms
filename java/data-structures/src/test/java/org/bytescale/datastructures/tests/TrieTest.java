package org.bytescale.datastructures.tests;

import org.apache.commons.io.FileUtils;
import org.bytescale.datastructures.spec.trees.Trie;
import org.bytescale.datastructures.util.trees.MapTrie;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    private List<String> words;

    @Before
    public void setup() throws IOException {
        File wordFile = new File("./src/test/resources/TrieTestWords.txt");
        words = FileUtils.readLines(wordFile);
    }

    @Test
    public void testTrie() {
        Trie<Info> trie = new MapTrie<Info>();

        for (String word : words) {
            trie.addValue(word, new Info(word));
        }

        Collection<Info> searchResults = trie.findValues("agonize");
        assertEquals(7, searchResults.size());
    }

    public static class Info {
        static Random rand = new Random(Calendar.getInstance().getTimeInMillis());
        private String key;
        private double someValue;

        public String getKey() { return key; }
        public void setKey(String key) { this.key = key; }

        public double getValue() { return rand.nextDouble(); }

        public Info(String key) {
            this.key = key;
        }
    }
}
