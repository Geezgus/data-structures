package com.github.geezgus.datastructure;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> extends AbstractArrayCollection<T> implements Queue<T> {

    @Override
    public T dequeue() {
        T dequeued = peek();

        excludeAt(0);

        return dequeued;
    }

    @Override
    public void enqueue(T item) {
        includeAt(size(), item);
    }

    @Override
    public T peek() {
        assertIndexIsGettable(0);
        return (T) array[0];
    }

}
