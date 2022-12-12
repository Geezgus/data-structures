package com.github.geezgus.datastructure;

public abstract class AbstractLinkedList<T> extends AbstractLinkedCollection<T> implements List<T> {

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
    public T get(int index) throws IndexOutOfBoundsException {
        assertIndexIsGettable(index);

        Node<T> temp = getNodeAt(index);
        return temp.item;
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

        Node<T> temp = getNodeAt(index);
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;

        size--;
    }

}
