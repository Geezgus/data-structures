package com.github.geezgus.datastructure;

@SuppressWarnings("unchecked")
public class ArrayStack<T> extends AbstractArrayCollection<T> implements Stack<T> {

    @Override
    public T peek() {
        assertIndexIsGettable(size() - 1);
        return (T) array[size() - 1];
    }

    @Override
    public T pop() {
        T popped = peek();

        excludeAt(size() - 1);

        return popped;
    }

    @Override
    public void push(T item) {
        includeAt(size(), item);
    }

}
