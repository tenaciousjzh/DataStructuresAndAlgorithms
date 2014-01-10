package org.bytescale.datastructures.spec.lists;

/**
 * Created by Jared on 1/8/14.
 */
public interface Stack<E> {
    public void push(E item);
    public E pop();
    public E peek();
}
