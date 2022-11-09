package com.github.geezgus.datastructure;

import java.util.Arrays;

public abstract class AbstractArrayCollection<T> extends AbstractCollection<T> {

    protected final Object[] DEFAULT_ARRAY = new Object[10];

    protected Object[] array;

    public AbstractArrayCollection() {
        array = DEFAULT_ARRAY;
    }

    public AbstractArrayCollection(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size(); i++) {
            if (item.equals(array[i])) {
                return true;
            }
        }

        return false;
    }

    protected void excludeAt(int index) {
        for (int i = index; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size() - 1] = null;
        size--;
    }

    protected void includeAt(int index, T item) {
        growArrayIfNeeded();

        for (int i = size(); i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size() - 1]).append(']');

        return sb.toString();
    }

    protected void growArrayIfNeeded() {
        if (size() >= array.length) {
            array = Arrays.copyOf(array, array.length + (array.length / 2));
        }
    }

}
