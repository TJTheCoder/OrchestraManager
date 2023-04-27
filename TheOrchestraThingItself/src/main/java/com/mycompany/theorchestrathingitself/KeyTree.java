package com.mycompany.theorchestrathingitself;

public class KeyTree {
    private KeyNode root;

    public KeyTree() {
        root = null;
    }

    public KeyTree(KeyNode root) {
        this.root = root;
    }

    public KeyNode getRoot() {
        return root;
    }

    public void setRoot(KeyNode root) {
        this.root = root;
    }

    public KeyNode find(int index) {
        KeyNode current = root;
        while (current != null) {
            if (index == current.getIndex()) {
                return current;
            } else if (index < current.getIndex()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public void insert(int index, int modifier) {
        KeyNode newNode = new KeyNode(index, modifier);
        if (root == null) {
            root = newNode;
        } else {
            KeyNode current = root;
            KeyNode parent;
            while (true) {
                parent = current;
                if (index < current.getIndex()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }
}
