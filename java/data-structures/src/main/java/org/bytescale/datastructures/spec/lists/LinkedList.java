package org.bytescale.datastructures.spec.lists;

import java.util.Iterator;

/**
 * Created by Jared on 1/3/14.
 */
public interface LinkedList<T> extends Iterator<T>, Iterable<T>, List<T> {
    public T head();
    public T tail();
}
