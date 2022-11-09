package com.github.geezgus.datastructure;

public class LinkedStack<T> extends AbstractLinkedCollection<T> implements Stack<T> {

    @Override
    public T peek() {
        assertIndexIsGettable(size() - 1);
        return tail.item;
    }

    @Override
    public T pop() {
        T popped = peek();

        excludeTailNode();

        return popped;
    }

    @Override
    public void push(T item) {
        includeTailNode(item);
    }

}
