package org.bytescale.datastructures.impl;

/**
 * Created by Jared on 1/3/14.
 */
public class ListItem<E> {
    private final E item;
    private ListItem<E> next;

    public ListItem(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public ListItem<E> getNext() {
        return next;
    }

    public void setNext(ListItem<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        ListItem<E> otherItem = (ListItem<E>) other;
        E thisItemValue = this.getItem();
        E otherItemValue = otherItem.getItem();

        if (thisItemValue.equals(otherItemValue) &&
                (this.getNext() == null && otherItem.getNext() == null) ||
                (this.getNext().equals(otherItem.getNext()))) {
            return true;
        }

        return false;
    }
}
