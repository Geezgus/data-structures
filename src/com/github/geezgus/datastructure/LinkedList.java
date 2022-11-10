package com.github.geezgus.datastructure;

public class LinkedList<T> extends AbstractLinkedCollection<T> implements List<T> {

    @Override
    public int indexOf(T item) {
        Node<T> temp = head;
        for (int i = 0; i < size(); i++) {
            if (item.equals(temp.item)) {
                return i;
            }
            temp = temp.next;
        }

        return -1;
    }

    @Override
    public void insert(int index, T item) throws IndexOutOfBoundsException {
        assertIndexIsSettable(index);

        if (index == 0) {
            includeHeadNode(item);
            return;
        }

        if (index == size()) {
            includeTailNode(item);
            return;
        }

        Node<T> temp = getListNode(index);

        temp = new Node<>(temp.previous, item, temp);
        temp.previous.next = temp;
        temp.next.previous = temp;

        size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);

        Node<T> temp = getListNode(index);
        return temp.item;
    }

    private Node<T> getListNode(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    @Override
    public void removeAt(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);

        if (index == 0) {
            excludeHeadNode();
            return;
        }

        if (index == size() - 1) {
            excludeTailNode();
            return;
        }

        Node<T> temp = getListNode(index);
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;

        size--;
    }

    @Override
    public void set(int index, T item) throws IndexOutOfBoundsException {
        Node<T> temp = getListNode(index);
        temp.item = item;
    }

}
