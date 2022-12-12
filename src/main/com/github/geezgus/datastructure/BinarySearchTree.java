package com.github.geezgus.datastructure;

import java.util.Comparator;

public class BinarySearchTree<T> {
    public Comparator<T> comparator;
    public int searchLimit = 1;
    protected Node<T> root = null;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    //region add()
    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
            return;
        }

        addChild(value, root);
    }

    private void addChild(T value, Node<T> root) {
        if (comparator.compare(value, root.value) < 0) {
            addToLeftSubtree(value, root);
        } else {
            addToRightSubtree(value, root);
        }
    }

    private void addToLeftSubtree(T value, Node<T> root) {
        if (root.left == null) {
            root.left = new Node<>(value, root);
            return;
        }

        addChild(value, root.left);
    }

    private void addToRightSubtree(T value, Node<T> root) {
        if (root.right == null) {
            root.right = new Node<>(value, root);
            return;
        }

        addChild(value, root.right);
    }
    //endregion

    //region find()
    public T find(T value) {
        return findNode(value, root).value;
    }

    private Node<T> findNode(T value, Node<T> root) {
        if (root == null) {
            return null;
        }

        if (comparator.compare(value, root.value) < 0) {
            return findNode(value, root.left);
        }

        if (comparator.compare(value, root.value) > 0) {
            return findNode(value, root.right);
        }

        return root;
    }
    //endregion

    //region toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildStringInOrder(root, sb, 0);
        return sb.toString().replaceFirst("\n$", "");
    }

    private void buildStringInOrder(Node<T> root, StringBuilder builder, int resultNumber) {
        if (root == null || resultNumber > searchLimit) return;
        int number = resultNumber;

        buildStringInOrder(root.left, builder, ++number);
        builder.append(root.value).append("\n");
        buildStringInOrder(root.right, builder, ++number);
    }
    //endregion

    static class Node<T> {
        T value;
        Node<T> left = null;
        Node<T> parent = null;
        Node<T> right = null;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
