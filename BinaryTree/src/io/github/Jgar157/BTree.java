package io.github.Jgar157;

public class BTree <T> {

    private Node<T> root;
    private Node<T> currentNode;

    public BTree() {
        root = null;

    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {

        if (node.getData() == data || node.getData().equals(data))
            return true;

        if (node.getLeftChild() != null)
            if (search(node.getLeftChild(),data))
                return true;

            if (node.getRightChild() != null)
                if (search(node.getRightChild(), data))
                    return true;

            return false;

    }

    public void printInOrder() {
        this.root.printInorder(root);
    }

    public void printPreOrder() {
        this.root.printPreorder(root);
    }

    public void printPostOrder() {
        this.root.printPostorder(root);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> node) {
        int count = 1;
        if (node == null) {
            return 0;
        }
        else {
            count += countNodes(node.getLeftChild());
            count+= countNodes(node.getRightChild());
            return count;
        }
    }

    public void print() {
        root.print();
    }

    public Node<T> getCurrent() {
        return currentNode;
    }

    public void setCurrent(Node<T> node) {
        this.currentNode = node;
    }
}
