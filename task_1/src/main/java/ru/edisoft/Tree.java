package ru.edisoft;

public class Tree {

    private Node root = null;

    private class Node {

        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this(data, null, null, null);
        }

        public Node(int data, Node left, Node right, Node parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }

    public Tree() {
    }

    public Tree(int[] values) {
        insert(values);
    }

    public void insert(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        for (int value : values) {
            insert(value);
        }
    }

    public void insert(int num) {
        insert(new Node(num));
    }

    private void insert(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (newNode.data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        int maxHeight = 0;
        for (Node child = node.left; child != null; child = child.right) {
            int hChild = height(child);
            if (hChild > maxHeight) maxHeight = hChild;
        }
        return maxHeight + 1;
    }

}
