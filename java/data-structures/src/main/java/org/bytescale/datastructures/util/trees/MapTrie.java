package org.bytescale.datastructures.util.trees;

import org.bytescale.datastructures.spec.trees.Trie;
import org.bytescale.datastructures.spec.trees.TrieNode;

import java.util.ArrayList;
import java.util.Collection;

public class MapTrie<T> implements Trie<T> {
    TrieNode<T> root = new MapTrieNode<T>();

    @Override
    public void addValue(String key, T value) {
        root.addValue(key, 0, value);
    }

    @Override
    public Collection<T> findValues(String key) {
        TrieNode<T> next = root;
        int index = 0;
        //follow the key to the last node in the Trie hierarchy
        while (index < key.length() &&
                next.getNext(new Character(key.charAt(index))) != null) {
            next = next.getNext(new Character(key.charAt(index++)));
        }
        if (index == key.length()) {
            return next.getChildValues();
        } else {
            return new ArrayList<T>();
        }

    }
}
