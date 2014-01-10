package org.bytescale.datastructures.spec.lists;

public interface Queue<E> {
    public void add(E item);
    public E remove();
    public E peek();
}
