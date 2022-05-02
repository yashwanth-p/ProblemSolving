package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    Queue<Node> queue = new LinkedList<>();

    public Node getRoot() {
        return root;
    }


    Node getASampleTree() {


        this.root = new Node(3);
        this.root.left = new Node(4);
        this.root.right = new Node(5);
        this.root.right.right = new Node(10);
        this.root.left.left = new Node(7);
        this.root.left.right = new Node(9);
        this.root.left.right.right = new Node(15);
        this.root.left.right.right.right = new Node(18);

        return this.root;
    }

    void clearTree() {
        this.root = null;
    }

    void printLevelOrder() {
        System.out.println();
        Queue<Node> queue = new LinkedList<>();
        if (this.root == null) return;
        queue.add(this.root);
        while (!queue.isEmpty()) {
            // pop it -- print it -- add children
            Node current = queue.poll();
            System.out.print(current.data + " - ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    void insert(int data) {
        levelOrderInsert(data);
    }
    void levelOrderInsert(int data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            } else {
                current.left = newNode;
                return;
            }

            if (current.right != null) {
                queue.add(current.right);
            } else {
                current.right = newNode;
                return;
            }
        }
    }

    Node buildLevelOrderTree(int[] elements) {
        Queue<Node> q = new LinkedList<>();
        for(int i: elements) {
            Node newNode = new Node(i);
            if(q.isEmpty()) {
                root = newNode;
                q.add(newNode);
                continue;
            }
            Node cur = q.peek();
            if(cur.left==null) {
                cur.left = newNode;
            } else if (cur.right == null) {
                cur.right = newNode;
                q.poll();
            }
            q.add(newNode);
        }

        return root;
    }

    Node delete(int key) {
        // implement delete operation
        return null;
    }


    public Node buildTree(int[] elements) {
        return  buildLevelOrderTree(elements);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}


