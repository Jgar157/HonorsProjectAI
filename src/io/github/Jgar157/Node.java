package io.github.Jgar157;

public class Node {

    int data;
    Node leftChild = null;
    Node rightChild = null;

    public Node(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;

    }

    /**
     * To add a node to the current left node. If the current
     * left node is null then set left equal to node.
     * @param node      The node representing the left Child
     */
    public void setLeft(Node node) {

        if (this.leftChild == null) {
            this.leftChild = node;
        }

    }

    /**
     * To add a node to the current right node. If the current
     * right node is null then set left equal to node.
     * @param node      The node representing the right Child
     */
    public void setRight(Node node) {

        if (this.rightChild == null) {
            this.rightChild = node;
        }

    }

    /**
     * @return      Return the current left node
     */
    public Node getLeft() {
        return this.leftChild;
    }

    /**
     * @return      Return the current right node
     */
    public Node getRight() {
        return this.rightChild;
    }

    /**
     * Sets the value of data of the node
     * @param data      The value of the node
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Returns the value of data of the node
     * @return      Gets the value of current node
     */
    public int getData() {
        return this.data;
    }

    // public void print();


}
