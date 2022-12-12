package com.github.geezgus.datastructure;

/**
 * Abstracts away every behaviour shared between all kinds of Collection<T>.
 *
 * @param <T>
 */
public abstract class AbstractCollection<T> implements Collection<T> {

    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    /**
     * Asserts the position of the Collection<T> provided by the index is settable.
     *
     * @param index The index of the Collection<T> to be checked for set-ability.
     * @throws IndexOutOfBoundsException If index is less than 0 or greater than the size of the Collection<T>.
     */
    protected void assertIndexIsSettable(int index) throws IndexOutOfBoundsException {
        if (0 > index || index > size()) {
            throw new IndexOutOfBoundsException("The collection could not be modified at index %d".formatted(index));
        }
    }

    /**
     * Asserts the position of the Collection<T> provided by the index is gettable.
     *
     * @param index The index of the Collection<T> to be checked for get-ability.
     * @throws IndexOutOfBoundsException If index is less than 0 or greater than or equal to the size of the Collection<T>.
     */
    protected void assertIndexIsGettable(int index) throws IndexOutOfBoundsException {
        if (0 > index || index >= size()) {
            throw new IndexOutOfBoundsException("No item of the collection at index %d could be retrieved".formatted(index));
        }
    }

}
