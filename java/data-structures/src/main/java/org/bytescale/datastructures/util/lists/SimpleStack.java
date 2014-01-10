package org.bytescale.datastructures.util.lists;

import org.bytescale.datastructures.spec.lists.Stack;

import java.util.ArrayList;

public class SimpleStack<E> implements Stack<E> {
    private ArrayList<E> stack;

    public SimpleStack() {
        stack = new ArrayList<E>();
    }

    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public E pop() {
        E item = stack.remove(stack.size() - 1);
        return item;
    }

    @Override
    public E peek() {
        return stack.get(stack.size() - 1);
    }
}
