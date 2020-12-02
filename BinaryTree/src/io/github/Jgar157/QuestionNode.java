package io.github.Jgar157;

public class QuestionNode<T> extends Node<T> {

    String parentPath = "";

    QuestionNode<T> leftChild = null;
    QuestionNode<T> rightChild = null;

    public QuestionNode(T data) {
        super(data);
    }

    public QuestionNode(T data, String parentPath) {
        super(data);
        this.parentPath = parentPath;
    }

    public QuestionNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(QuestionNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public QuestionNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(QuestionNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public String getParentPath() {
        return this.parentPath;
    }

    public void setParentPath(String type) {
        this.parentPath = parentPath;
    }
}
