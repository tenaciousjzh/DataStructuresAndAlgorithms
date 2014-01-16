package org.bytescale.datastructures.util.lists;

import org.bytescale.datastructures.spec.lists.List;

public class SimpleArrayList<T> implements List<T> {
    private Object[] items;
    private int currentIndex = 0;

    public SimpleArrayList() {
        items = new Object[10];
    }

    public SimpleArrayList(int initialCapacity) {
        items = new Object[initialCapacity];
    }


    @Override
    public void add(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Cannot insert a null value for the item argument to the SimpleArrayList");
        }
        if (currentIndex + 1 > items.length) {
            increaseCapacity();
        }
        items[currentIndex] = item;
        currentIndex++;
    }

    private void increaseCapacity() {
        Object[] copyArray = new Object[items.length + 10];
        for (int i = 0; i < items.length; i++) {
            copyArray[i] = items[i];
        }
        items = copyArray;
    }

    @Override
    public void remove(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Cannot remove item based on the null argument given to the SimpleArrayList.");
        }
        int location = 0;
        for (Object o : items) {
            T candidate = (T) o;
            if (candidate.equals(item)) {
                break;
            }
            location++;
        }

        for (int shiftLocation = location; shiftLocation < (items.length - 1); shiftLocation++) {
            if (items[shiftLocation + 1] != null) {
                items[shiftLocation] = items[shiftLocation+1];
                currentIndex = shiftLocation;
            }
        }
        items[items.length -1] = null;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public T get(int index) {
        if (index <= currentIndex) {
            return (T)items[index];
        }
        return null;
    }

    @Override
    public boolean contains(T item) {
        boolean isContained = false;
        for (int i = 0; i < currentIndex; i++) {
            if (items[i] != null && item.equals((T)items[i])) {
                isContained = true;
                break;
            }
        }
        return isContained;
    }
}
