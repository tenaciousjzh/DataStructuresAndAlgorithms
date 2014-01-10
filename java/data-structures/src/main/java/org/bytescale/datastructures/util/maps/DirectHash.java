package org.bytescale.datastructures.util.maps;

import org.bytescale.datastructures.spec.maps.HashFunction;

public class DirectHash<K,V> implements HashFunction<K,V> {

    @Override
    public int hash(K key) {
        return key.hashCode();
    }
}
