package com.github.geezgus.datastructure;

import java.util.Comparator;

public class OrderedLinkedList<T> extends AbstractLinkedList<T> implements List<T> {

    private final Comparator<T> comparator;

    public OrderedLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(T item) {
        int index = getInsertionIndexOfItem(item);

        try {
            includeNodeAt(index, item);
        } catch (Exception ignored) {
            return false;
        }
        
        return true;
    }

    private int getInsertionIndexOfItem(T item) {
        int index = 0;

        while (index < size()) {
            if (comparator.compare(item, get(index)) <= 0)
                break;
            index++;
        }

        return index;
    }

    @Override
    public void set(int index, T item) throws IndexOutOfBoundsException {
        removeAt(index);
        add(item);
    }

}
