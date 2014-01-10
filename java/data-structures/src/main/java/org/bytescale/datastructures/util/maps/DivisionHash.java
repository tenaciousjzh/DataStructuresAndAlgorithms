package org.bytescale.datastructures.util.maps;

import org.bytescale.datastructures.spec.maps.HashFunction;

public class DivisionHash<K,V> implements HashFunction<K,V> {
    private V[] table;
    public DivisionHash(V[] table) {
        this.table = table;
    }

    @Override
    public int hash(K key) {
        return key.hashCode() % table.length;
    }
}
