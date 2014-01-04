package org.bytescale.datastructures.util.trees;

import org.bytescale.datastructures.spec.trees.TrieNode;

import java.util.*;

public class MapTrieNode<T> implements TrieNode<T> {
    private Map<Character, TrieNode<T>> nextNode = new HashMap<Character, TrieNode<T>>();
    private List<T> values = new ArrayList<T>();

    /**
     * Adds a new value to the Trie structure based on the key.
     * Key is broken down character by character until it has properly been distributed,
     * wherein value will be stored into the values collection.
     * @param key
     * @param depth
     * @param value
     */
    @Override
    public void addValue(String key, int depth, T value) {
        if (depth < key.length()) {
            //keep appending nodes until we reach the end of the key
            TrieNode<T> subNode = nextNode.get(key.charAt(depth));
            if (subNode == null) {
                subNode = new MapTrieNode<T>();
                nextNode.put(new Character(key.charAt(depth)), subNode);
            }
            subNode.addValue(key, depth + 1, value);
        } else {
            values.add(value);
        }

    }

    /**
     * Gets a sub node for a specific character given
     * @param c
     * @return
     */
    @Override
    public TrieNode<T> getNext(char c) {
        TrieNode<T> node = nextNode.get(new Character(c));
        if (node != null) {
            return node;
        }
        return null;
    }

    /**
     * Get only the values assigned to this node
     * @return
     */
    @Override
    public Collection<T> getValues() {
        return this.values;
    }
    /**
     * Get all the values under this node
     * @return
     */
    @Override
    public Collection<T> getChildValues() {
        List<T> recursiveVals = new ArrayList<T>();
        recursiveVals.addAll(this.getValues());
        for (TrieNode<T> subNode : nextNode.values()) {
            recursiveVals.addAll(subNode.getChildValues());
        }
        return recursiveVals;
    }
}
