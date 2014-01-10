package org.bytescale.datastructures.util.maps;

import org.bytescale.datastructures.spec.maps.HashFunction;
import org.bytescale.datastructures.spec.maps.HashTable;

import java.util.Calendar;
import java.util.Random;

public class SimpleHashTable<K, V> implements HashTable<K, V> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] table;
    private Object[] keys;
    private HashFunction<K, V> hashFunction;
    private int size;

    public SimpleHashTable() {
        table = new Object[DEFAULT_SIZE];
        keys = new Object[DEFAULT_SIZE];
        hashFunction = new DivisionHash<K, V>((V[]) table);
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int hashKey = getHashKey(key);
        if (contains(hashKey) == false) {
            size++;
        }

        if (size >= table.length) {
            increaseTableSize();
        }
        table[hashKey] = value;
        keys[hashKey] = key;
    }

    private void increaseTableSize() {
        Object[] newKeys = new Object[keys.length + DEFAULT_SIZE];
        Object[] newTable = new Object[table.length + DEFAULT_SIZE];

        for (int index = 0; index < keys.length; index++) {
            K key = (K) keys[index];
            newKeys[index] = key;
            newTable[index] = table[index];
        }

        keys = newKeys;
        table = newTable;
    }

    @Override
    public V get(K key) {
        int hashKey = getHashKey(key);
        if (table[hashKey] != null) {
            return (V) table[hashKey];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        int hashKey = getHashKey(key);
        return contains(hashKey);
    }

    private boolean contains(int hashKey) {
        if (table[hashKey] != null) {
            return true;
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int hashKey = getHashKey(key);
        if (table[hashKey] != null) {
            table[hashKey] = null;
            size--;
        }
    }

    private int getHashKey(K key) {
        int hashKey = hashFunction.hash(key);
        if (keys[hashKey] != null &&
                keys[hashKey].equals(key)) {
            //hashkey is good
        } else if (keys[hashKey] != null) {
            //need to return hashKey from index selected as a result of collision
            boolean foundKey = false;
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    hashKey = i;
                    foundKey = true;
                    break;
                }
            }
            if (foundKey == false) {
                hashKey = candidateFromCollision(key);
            }
        }
        return hashKey;
    }

    private int candidateFromCollision(K k) {
        int hashValue = hashFunction.hash(k);
        Random rand = new Random(Calendar.getInstance().getTimeInMillis());
        int hashKey = (hashValue + rand.nextInt(size)) % table.length;
        while (table[hashKey] != null) {
            hashKey = (hashValue + rand.nextInt(size)) % table.length;
        }
        return hashKey;
    }
}
