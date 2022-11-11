package com.github.geezgus.datastructure;

/**
 * Defines methods to manipulate generic collections.
 *
 * @param <T>
 */
public interface Collection<T> {

    /**
     * Removes all items from the Collection<T>.
     */
    void clear();

    /**
     * Determines whether the Collection<T> contains a specific value.
     *
     * @param item The object to locate in the Collection<T>.
     * @return true if item is found in the Collection<T>; otherwise, false.
     */
    boolean contains(T item);

    /**
     * Gets the number of elements contained in the Collection<T>.
     *
     * @return The number of elements contained in the Collection<T>.
     */
    int size();

    /**
     * Returns whether the Collection<T> is empty or not
     *
     * @return true if Collection<T> is empty; otherwise, false.
     */
    default boolean isEmpty() {
        return size() == 0;
    }

}
