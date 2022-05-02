package DSA.Trees;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class PreOrderTrees_BST {

    static int index = 0;
    static int[] preOrder = {16, 9, 6, 3, 12, 10, 25, 18, 29};
    static boolean isSuccessor;

    public static void main(String[] args) {
        constructTreeUtil();
    }

    private static void constructTreeUtil() {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Node root = constructTree(preOrder[0], min, max);
        //executeMethods1(root);
        executeMethods2(root);
    }

    private static void executeMethods2(Node root) {
        Map<Integer, Integer> path = new HashMap<>();
        printRootToLeafPaths(root, path, 1);
    }

    private static void printRootToLeafPaths(Node current, Map<Integer, Integer> path, int level) {
        if (current == null) return;


        path.put(level, current.data);
        printRootToLeafPaths(current.left, path, level+1);
        printRootToLeafPaths(current.right, path, level+1);
        if(isLeaf(current)) {
            printPath(path);
        }
        path.remove(level);
    }

    private static boolean isLeaf(Node current) {
        return  current.left == null && current.right == null;
    }

    private static void executeMethods1(Node root) {
        Node temp = root;
        printPreOrder(temp);
        printInOrderIterative(temp);
        temp = root;
        inOrderSuccessor(temp, 16);
        // print the path to given node data. impl w.r.t Binary tree
        printPathToNodeUtil(10, temp);
    }

    private static void printInOrderIterative(Node current) {
        System.out.println("Iterative Inorder traversal");
        if(current == null) return;
        Stack<Node> stack = new Stack<>();
        while (current!=null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;

        }


    }

    private static void printPathToNodeUtil(int key, Node current) {
        Map<Integer, Integer> path = new LinkedHashMap<>();
        System.out.println("Path to the node element: " + key);
        printPathToNode(current, key, path, 1);
    }

    private static void printPathToNode(Node current, int key, Map<Integer, Integer> path, int level) {
        if(current == null) return;
        path.put(level, current.data);
        if(current.data == key) {
            printPath(path);
            return;
        }
        printPathToNode(current.left, key, path, level+1);
        printPathToNode(current.right, key, path, level+1);
        path.remove(level);
    }

    private static void printPath(Map<Integer, Integer> path) {
        for(int pathElement : path.values() ) {
            System.out.print(pathElement + "  ");
        }
        System.out.println();
    }

    private static void inOrderSuccessor(Node root, int key) {

        if(root != null) {
            inOrderSuccessor(root.left, key);
            if(isSuccessor) {
                System.out.printf("Inorder Successor of %d is %d%n", key, root.data);
                isSuccessor = false;
                return;
            }
            if (key == root.data) isSuccessor = true;
            inOrderSuccessor(root.right, key);
        }
    }

    private static Node constructTree(int key, int min, int max) {

        Node current = null;
        if (!outOfRange(key, min, max)) {
            current = new Node(key);
            index++;
            if (indexInRange(index)) {
                current.left = constructTree(preOrder[index], min, key);
                current.right = constructTree(preOrder[index], key, max);
            }
        }
        return current;

    }

    private static boolean indexInRange(int index) {
        return index < preOrder.length;
    }

    private static boolean outOfRange(int i, int min, int max) {
        return i<min || i>max ;
    }

    private static void printPreOrder(Node current) {
        if (current != null) {
            System.out.println(current.data);
            printPreOrder(current.left);
            printPreOrder(current.right);
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

    }
}

