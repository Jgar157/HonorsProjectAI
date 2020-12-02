package io.github.Jgar157;

public class Node<T> {


    T data;
    Node<T> leftChild = null;
    Node<T> rightChild = null;

    public Node(T data) {

        this.data = data;
        leftChild = null;
        rightChild = null;

    }

    /**
     * To add a node to the current left node. If the current
     * left node is null then set left equal to node.
     * @param node      The node representing the left Child
     */
    public void setLeftChild(Node<T> node) {

        if (this.leftChild == null) {
            this.leftChild = node;
        }

    }

    /**
     * To add a node to the current right node. If the current
     * right node is null then set left equal to node.
     * @param node      The node representing the right Child
     */
    public void setRightChild(Node<T> node) {

        if (this.rightChild == null) {
            this.rightChild = node;
        }

    }

    /**
     * @return      Return the current left node
     */
    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    /**
     * @return      Return the current right node
     */
    public Node<T> getRightChild() {
        return this.rightChild;
    }

    /**
     * Sets the value of data of the node
     * @param data      The value of the node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the value of data of the node
     * @return      Gets the value of current node
     */
    public T getData() {
        return this.data;
    }

    // public void print();

    public void printPreorder(Node<T> node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.getLeftChild());
        printPreorder(node.getRightChild());
    }

    void printPostorder(Node<T> node) {
        if (node == null)
            return;

        printPostorder(node.getLeftChild());
        printPostorder(node.getRightChild());
        System.out.print(node.data + " ");

    }

    void printInorder(Node<T> node) {
         if (node == null)
             return;

         printInorder(node.getLeftChild());
         System.out.print(node.data + " ");
         printInorder(node.getRightChild());

    }

    public String print() {
        return this.print("" ,true, "");
    }

    public String print(String prefix, boolean isTail, String sb) {

        if (this.getRightChild() != null) {
            this.getRightChild().print(prefix + (isTail ? "│   " : "    "), false, sb);
        }

        System.out.println( prefix + (isTail ? "\\-- " : "/-- ") + data);
        if (this.getLeftChild() != null) {
            this.getLeftChild().print(prefix + (isTail ? "    " : "│   "), true, sb);
        }

        return sb;
    }


}
