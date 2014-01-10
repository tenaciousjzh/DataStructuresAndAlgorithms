package org.bytescale.datastructures.spec.maps;

public interface HashFunction<K, V> {
    int hash(K key);
}
