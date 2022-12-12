package com.github.geezgus.datastructure;

public class LinkedQueue<T> extends AbstractLinkedCollection<T> implements Queue<T> {

    @Override
    public T dequeue() {
        T dequeued = peek();

        excludeHeadNode();

        return dequeued;
    }

    @Override
    public void enqueue(T item) {
        includeTailNode(item);
    }

    @Override
    public T peek() {
        assertIndexIsGettable(0);
        return head.item;
    }

}
