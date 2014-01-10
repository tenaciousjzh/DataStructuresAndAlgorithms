package org.bytescale.datastructures.spec.lists;

public interface List<T> {
    public void add(T item)
            throws IllegalArgumentException;
    public void remove(T item)
            throws IllegalArgumentException;
    public int size();
    public T get(int index);
    public boolean contains(T item);
}
