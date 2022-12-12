package com.github.geezgus.datastructure;

/**
 * Represents a last-in, first-out kind of structure of objects.
 *
 * @param <T>
 */
public interface Stack<T> extends Collection<T> {

    /**
     * Returns the object at the top of the Stack<T> without removing
     * it.
     *
     * @return The object at the top of the Stack<T>.
     */
    T peek();

    /**
     * Removes the top element from the Stack<T>.
     *
     * @return The object removed from the top of the Stack<T>.
     */
    T pop();

    /**
     * Adds an item to the top of a Stack<T>.
     *
     * @param item The object to add to the Stack<T>.
     */
    void push(T item);

}
