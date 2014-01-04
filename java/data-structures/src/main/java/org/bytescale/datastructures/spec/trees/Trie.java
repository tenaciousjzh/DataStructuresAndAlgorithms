package org.bytescale.datastructures.spec.trees;

import java.util.Collection;

public interface Trie<T> {
    public void addValue(String key, T value);
    public Collection<T> findValues(String key);
}
