package org.bytescale.datastructures.spec.maps;

public interface HashTable<K, V> {
    public void put(K key, V value);
    public V get(K key);
    public int size();
    public boolean contains(K key);
    public void remove(K key);
}
