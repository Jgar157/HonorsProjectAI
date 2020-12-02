package io.github.Jgar157;

public class TreeDriver {

    public static void main(String[] args) {
        System.out.println("Creating Tree");
        BTree tree = new BTree();

        System.out.println("Count nodes in empty tree");
        System.out.println(tree.countNodes());

        System.out.println("Creat Nodes with data 1");
        Node root = new Node(1);

        System.out.println("Set node as root");
        tree.setRoot(root);

        System.out.println("Count nodes in tree with only root added");
        System.out.println(tree.countNodes());
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.setLeftChild(node2);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node5.setLeftChild(node7);
        root.setRightChild(node3);
        node3.setRightChild(node6);

        System.out.println("Set the current node to be the root");
        tree.setCurrent(tree.getRoot());

        System.out.println("Display the current node");
        System.out.println(tree.getCurrent().getData());

        Node currentNode = tree.getCurrent();

        System.out.println("Count nodes in tree with 7 nodes added");
        System.out.println(tree.countNodes());

        System.out.println("In Order print");
        tree.printInOrder();

        System.out.println("\nPre order print");
        tree.printPreOrder();

        System.out.println("\nPost order print");
        tree.printPostOrder();

        System.out.println("\nDisplay the nodes as tree diagram");
        tree.print();
    }
}
