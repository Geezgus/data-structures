package com.github.geezgus.datastructure;

public class LinkedList<T> extends AbstractLinkedList<T> implements UnorderedList<T> {

    @Override
    public void insert(int index, T item) throws IndexOutOfBoundsException {
        includeNodeAt(index, item);
    }

    @Override
    public void set(int index, T item) throws IndexOutOfBoundsException {
        Node<T> temp = getNodeAt(index);
        temp.item = item;
    }

}
