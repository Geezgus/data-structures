package com.github.geezgus.datastructure;

abstract class AbstractLinkedCollection<T> extends AbstractCollection<T> {

    Node<T> head = null;
    Node<T> tail = null;

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(T item) {
        Node<T> temp = head;

        for (int i = 0; i < size(); i++) {
            if (item.equals(temp.item)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    private void excludeFirstNode() {
        head = null;
        size--;
    }

    protected void excludeHeadNode() {
        if (size() == 1) {
            excludeFirstNode();
            return;
        }

        head = head.next;
        head.previous = null;
        size--;
    }

    protected void excludeTailNode() {
        if (size() == 1) {
            excludeFirstNode();
            return;
        }

        tail = tail.previous;
        tail.next = null;
        size--;
    }

    private void includeFirstNode(T item) {
        head = new Node<>(null, item, null);
        tail = head;
        size++;
    }

    protected void includeHeadNode(T item) {
        if (size() == 0) {
            includeFirstNode(item);
            return;
        }

        head.previous = new Node<>(null, item, head);
        head = head.previous;
        size++;
    }

    protected void includeTailNode(T item) {
        if (size() == 0) {
            includeFirstNode(item);
            return;
        }

        tail.next = new Node<>(tail, item, null);
        tail = tail.next;
        size++;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        {
            Node<T> temp = head;
            for (int i = 0; i < size() - 1; i++) {
                sb.append(temp.item).append(", ");
                temp = temp.next;
            }
            sb.append(temp.item).append(']');
        }

        return sb.toString();
    }

    protected static class Node<T> {
        Node<T> previous;
        T item;
        Node<T> next;

        public Node(Node<T> previous, T item, Node<T> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

}