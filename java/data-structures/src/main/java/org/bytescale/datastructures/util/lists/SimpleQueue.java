package org.bytescale.datastructures.util.lists;

import org.bytescale.datastructures.spec.lists.Queue;

import java.util.ArrayList;

public class SimpleQueue<E> implements Queue<E> {
    ArrayList<E> list;

    public SimpleQueue() {
        list = new ArrayList<E>();
    }

    @Override
    public void add(E item) {
        list.add(item);
    }

    @Override
    public E remove() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }
}
