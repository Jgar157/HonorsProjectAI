package io.github.Jgar157;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class YesNoGame {

    BTree<QuestionNode<String>> binTree = new BTree<>();
    ArrayList<QuestionNode<String>> animalTree = new ArrayList<>();

    File file;
    Scanner scanner;

    public YesNoGame(String fileLocation) {

        this.file = new File(fileLocation);

        String choice = "";
        scanner = new Scanner(System.in);
        loadNodes();

        while (!choice.equalsIgnoreCase("X")) {

            choice = this.launchQuestions();
            this.makeChoice(choice);

        }

        saveNodes();
        scanner.close();

    }

    public String launchQuestions() {

        String temp;

        System.out.println("\nC to begin asking questions"); // End of question should auto-save
        System.out.println("O to output list");
        System.out.println("X to Exit");
        temp = scanner.nextLine();


        return temp;

    }

    public void  makeChoice(String decision) {

        if (decision.equalsIgnoreCase("C")) {
            this.beginGame();
        } else if (decision.equalsIgnoreCase("O")) {
            this.outputAnimalTree();
        }

    }

    public void saveNodes() {

        try {

            FileWriter writer = new FileWriter(this.file, false);

            // For loop iterates over the arrayList animalTree grabbing each node, it's data, it's path to ParentNode,
            // and the type of data that the node contains, (Q/A)
            for (QuestionNode<String> node: animalTree) {
                writer.write(String.format("%s %s \n", node.getData(), node.getParentPath()));
            }

            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void loadNodes() {

        try {

            scanner = new Scanner(this.file);

            while (scanner.hasNextLine()) {
                animalTree.add(new QuestionNode<>(scanner.next(), scanner.next()));
                if (scanner.hasNextLine())
                    scanner.nextLine();
            }

            scanner = new Scanner(System.in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Now that the arrayList animalTree is constructed, the nodes are loaded into their proper positions
        // starting from the back to the front. This allows the root node to contain every reference.
        loadChildrenIntoNodes();
    }

    public void outputTextFile() {
        for (QuestionNode<String> animalNodes: animalTree) {
            System.out.printf("%s %s \n", animalNodes.getData(), animalNodes.getParentPath());
        }
    }

    public void outputAnimalTree() {

        animalTree.get(0).print();
    }

    public void loadChildrenIntoNodes() {

        String leftOrRight;
        String numParent;

        for (int i = animalTree.size() - 1; i >= 0; i --) {

            leftOrRight = animalTree.get(i).getParentPath().substring(0,1);
            numParent = animalTree.get(i).getParentPath().substring(1);

            if (leftOrRight.equalsIgnoreCase("R"))
                animalTree.get(Integer.parseInt(numParent)).setRightChild(animalTree.get(i));
            else if (leftOrRight.equalsIgnoreCase("L"))
                animalTree.get(Integer.parseInt(numParent)).setLeftChild(animalTree.get(i));
            else
                System.out.println("\n");
        }
    }

    public void beginGame() {

        QuestionNode<String> currentNode = animalTree.get(0);
        scanner = new Scanner(System.in);
        String tempAnswer;

        QuestionNode<String> left = null;
        QuestionNode<String> right = null;

        do {

            System.out.println(currentNode.getData());
            tempAnswer = scanner.nextLine();

            if (tempAnswer.equalsIgnoreCase("Y") && currentNode.getRightChild() != null)
                currentNode = currentNode.getRightChild();
            else if (tempAnswer.equalsIgnoreCase("N") && currentNode.getLeftChild() != null)
                currentNode = currentNode.getLeftChild();

        } while (!"ABX".contains(tempAnswer) &&
                (currentNode.getRightChild() != null && currentNode.getLeftChild() != null));

        System.out.println("Were you thinking of " + currentNode.getData() + "?");

        tempAnswer = scanner.nextLine();

        if (tempAnswer.equalsIgnoreCase("Y"))
            System.out.println("Yay!! It worked \n\n\n");
        else if (tempAnswer.equalsIgnoreCase("N")) {
            String newAnimal;
            String prevAnimal = currentNode.getData();
            String parentIndex = String.valueOf(animalTree.indexOf(currentNode));
            String question;

            System.out.println("Oops, I thought I knew everything");
            System.out.println("What animal were you thinking of?");
            newAnimal = scanner.nextLine();
            System.out.println("What question would you ask?");
            question = scanner.nextLine();
            System.out.println("How would you answer that question?");

            tempAnswer = scanner.nextLine();
            if (tempAnswer.equalsIgnoreCase("Y")) {
                left = new QuestionNode<>(prevAnimal, "L" + parentIndex);
                right = new QuestionNode<>(newAnimal, "R" + parentIndex);



            } else if (tempAnswer.equalsIgnoreCase("N")) {
                left = new QuestionNode<>(newAnimal, "L" + parentIndex);
                right = new QuestionNode<>(prevAnimal, "R" + parentIndex);

                currentNode.setData(question);
                currentNode.setLeftChild(left);
                currentNode.setRightChild(right);
            }

            if (left != null & right != null) {
                animalTree.add(left);
                animalTree.add(right);

                currentNode.setData(question);
                currentNode.setLeftChild(left);
                currentNode.setRightChild(right);
            }


            loadChildrenIntoNodes();

        }




    }


}