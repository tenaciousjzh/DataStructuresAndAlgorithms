package org.bytescale.datastructures.spec.lists;

import java.util.Iterator;

/**
 * Created by Jared on 1/3/14.
 */
public interface LinkedList<T> extends Iterator<T>, Iterable<T> {
    public void add(T item) throws IllegalArgumentException;
    public void remove(T item);
    public boolean contains(T item);
    public T head();
    public T tail();
    public int size();
}
