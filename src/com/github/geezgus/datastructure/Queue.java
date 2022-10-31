package com.github.geezgus.datastructure;

/**
 * Represents a first-in, first-out kind of structure of objects.
 *
 * @param <T>
 */
public interface Queue<T> extends Collection<T> {
    /**
     * Removes and returns the object at the beginning of the Queue<T>.
     *
     * @return The object that is removed from the beginning of the Queue<T>.
     */
    T dequeue();

    /**
     * Adds an object to the end of the Queue<T>.
     *
     * @param item The object to add to the Queue<T>.
     */
    void enqueue(T item);

    /**
     * Returns the object at the beginning of the Queue<T> without
     * removing it.
     *
     * @return The object at the beginning of the Queue<T>.
     */
    T peek();

}
