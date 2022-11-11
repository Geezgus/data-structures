package com.github.geezgus.datastructure;

/**
 * Defines the base methods shared between all generic lists.
 *
 * @param <T>
 */
public interface List<T> extends Collection<T> {

    /**
     * Adds an item to the List<T>.
     *
     * @param item The object to add to the List<T>.
     * @return true if the item was successfully added to the List<T>; otherwise, false.
     */
    boolean add(T item);

    /**
     * Determines the index of a specific item in the List<T>.
     *
     * @param item The object to locate in the List<T>.
     * @return The index of item if found in the list; otherwise, -1.
     */
    int indexOf(T item);

    /**
     * Returns the item in the List<T> at the specified index.
     *
     * @param index The zero-based index of the item to be returned.
     * @return The item in the List<T> at the specified index.
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Removes the first occurrence of a specific object from the List<T>.
     *
     * @param item The object to remove from the List<T>.
     * @return true if item was successfully removed from the List<T>;
     * otherwise, false. This method also returns false if item is not
     * found in the original List<T>.
     */
    default boolean remove(T item) {
        try {
            removeAt(indexOf(item));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Removes the List<T> item at the specified index.
     *
     * @param index The zero-based index of the item to remove.
     * @throws IndexOutOfBoundsException If the position of the List<T> indicated by the provided index is not gettable.
     */
    void removeAt(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the item in the List<T> at the specified index.
     *
     * @param index The zero-based index of the item to be set.
     * @param item  The object to insert into the List<T> at the specified index.
     */
    void set(int index, T item) throws IndexOutOfBoundsException;

}
