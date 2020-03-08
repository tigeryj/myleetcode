package com.tiger.structure;

import java.util.Random;

/**
 * @auther Jack
 * @date 2020/3/1 17:56
 */

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;

    public void insert(Key k, Value v) {
        root = insert(root, k, v);
    }

    //插入
    private Node insert(Node root, Key k, Value v) {

        if (root == null) {
            return new Node(k, v);
        }

        if (k.compareTo(root.key) < 0) {
            root.left = insert(root.left, k, v);
        } else if (k.compareTo(root.key) > 0) {
            root.right = insert(root.right, k, v);
        } else {
            root.value = v;
        }
        return root;
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    //删除
    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {

            node.left = remove(node.left, key);
            return node;

        } else if (key.compareTo(node.key) > 0) {

            node.right = remove(node.right, key);
            return node;

        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                return right;
            }

            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                return left;
            }

            Node leftMax = new Node(maximum(node.left));
            removeMax(node.left);
            leftMax.left = node.left;
            leftMax.right = node.right;

            node.left = node.right = null;
            return leftMax;
        }
    }

    public void removeMax() {
        removeMax(root);
    }

    //删除最大元素
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public boolean contains(Key k) {
        return contains(root, k);
    }

    private boolean contains(Node node, Key k) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(k) == 0) {
            return true;
        } else if (k.compareTo(node.key) < 0) {
            return contains(node.left, k);
        } else {
            return contains(node.right, k);
        }
    }

    public Value search(Key key) {
        return search(root, key);
    }

    public void inTraversal() {
        inTraversal(root);
    }

    private void inTraversal(Node node) {
        if (node == null) {
            return;
        }
        inTraversal(node.left);
        System.out.print(node.key + "\t");
        inTraversal(node.right);
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Key maximum() {
        Node max = maximum(root);
        return max.key;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public Key minimum() {
        Node minNode = minimum(root);
        return minNode.key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public static void main(String[] args) {
        int N = 50;
        BST<Integer, String> bst = new BST<Integer, String>();

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < N; i++) {
            int rand = random.nextInt(1000);
            bst.insert(rand, Integer.toString(rand));
            bst.insert(666, "");
        }

        bst.inTraversal();

        bst.remove(666);
        System.out.println("\n===================");
        bst.inTraversal();
    }
}
