package com.github.geezgus.datastructure;

@SuppressWarnings("unchecked")
public class ArrayList<T> extends AbstractArrayCollection<T> implements UnorderedList<T> {

    public ArrayList() {
        super();
    }

    public ArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size(); i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void insert(int index, T item) throws IndexOutOfBoundsException {
        assertIndexIsSettable(index);
        includeAt(index, item);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);
        return (T) array[index];
    }

    @Override
    public void removeAt(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);
        excludeAt(index);
    }

    @Override
    public void set(int index, T item) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);
        array[index] = item;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}