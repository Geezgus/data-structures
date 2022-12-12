package com.github.geezgus.datastructure;

public interface UnorderedList<T> extends List<T> {

    /**
     * Inserts an item to the List<T> at the specified index.
     *
     * @param index The zero-based index at which item should be inserted.
     * @param item  The object to insert into the List<T>.
     * @throws IndexOutOfBoundsException If the position of the List<T> indicated by the provided index is not settable.
     */
    void insert(int index, T item) throws IndexOutOfBoundsException;

    @Override
    default boolean add(T item) {
        try {
            insert(size(), item);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}