package org.bytescale.datastructures.spec.trees;

import java.util.Collection;

public interface TrieNode<T> {
    public void addValue(String key, int depth, T value);
    public TrieNode<T> getNext(char c);
    public Collection<T> getChildValues();
    public Collection<T> getValues();
}
