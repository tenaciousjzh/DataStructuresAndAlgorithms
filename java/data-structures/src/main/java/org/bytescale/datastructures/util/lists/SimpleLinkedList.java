package org.bytescale.datastructures.util.lists;

import org.bytescale.datastructures.util.lists.ListItem;
import org.bytescale.datastructures.spec.lists.LinkedList;

import java.util.Iterator;

public class SimpleLinkedList<T> implements LinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    private ListItem<T> nextItem;
    private ListItem<T> previousItem;

    private int size = 0;
    boolean isFirstIteration = true;
    boolean resetForIteration = false;


    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item to the LinkedList");
        }

        ListItem<T> newItem = new ListItem(item);

        if (head == null) {
            //We have a one element list so we can stop here
            head = newItem;
            head.setNext(null);
            nextItem = head;
        } else {
            if (tail != null) {
                tail.setNext(newItem);
            } else {
                ListItem<T> current = head;

                //seek ahead in the list until you reach the end
                boolean hasMore = true;
                while (hasMore) {
                    if(current != null && current.getNext() != null) {
                        current = current.getNext();
                    } else {
                        hasMore = false;
                    }
                }
                current.setNext(newItem);
            }
            tail = newItem;
        }
        ++size;
    }

    @Override
    public void remove(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Item passed to be removed was null.");
        }

        if (head.getItem().equals(item)) {
            if (head != null) {
                if (head.getNext() != null) {
                    head = head.getNext();
                } else {
                    head = null;
                }
                nextItem = head;
            }
        } else if (tail.getItem().equals(item)) {
            ListItem<T> current = head;
            boolean seeking = true;
            while (seeking) {
                if (current != null && current.getNext() != null) {
                    if (current.getNext().equals(tail)) {
                        seeking = false;
                    } else {
                        current = current.getNext();
                    }
                }
            }
            if (current != head) {
                tail = current;
                tail.setNext(null);
            } else {
                current.setNext(null);
                tail = null;
            }
        } else {
            ListItem<T> previous = null;
            ListItem<T> current = head;

            boolean seeking = true;
            while (seeking) {
                if (current != null && current.getNext() != null) {
                    if (current.getItem().equals(item)) {
                        previous.setNext(current.getNext());
                        seeking = false;
                    }
                }
                previous = current;
                current = current.getNext();
            }
        }
        --size;
        if (size < 0) { size = 0; }
    }

    @Override
    public boolean contains(T item) {
        boolean containsItem = false;
        if (item == null) {
            return containsItem;
        }
        for (T element : this) {
            if (element.equals(item)) {
                containsItem = true;
                break;
            }
        }
        return containsItem;
    }

    @Override
    public T head() {
        if (head == null || head.getItem() == null) {
            return null;
        }
        return this.head.getItem();
    }

    @Override
    public T tail() {
        if (tail == null || tail.getItem() == null) {
            return null;
        }
        return this.tail.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = nextItem != null;
        if (resetForIteration) {
            nextItem = head;
        }
        return hasNext;
    }

    @Override
    public T next() {
        previousItem = nextItem;

        if (isFirstIteration) {
            isFirstIteration = false;
            resetForIteration = false;
            nextItem = head;
        } else {
            resetForIteration = false;
            nextItem = nextItem.getNext();
        }

        T item = nextItem.getItem();
        if (tail == null || item.equals(tail.getItem())) {
            isFirstIteration = true;
            nextItem = null; //sets our stopping condition
            resetForIteration = true;
        }

        return item;
    }

    @Override
    public void remove() {
        remove(previousItem.getItem());
    }
}