package DSA.Snippets;


import java.util.Stack;

public class IterativeTraversals {




    public static void inorder_Iterative(Node current) {
        // double loop
        if (current == null) return;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;

        }
    }

    public static void preOrder_Iterative(Node current) {
        // push - pop - push its children
        // push it first
        // then use the one as the condition to push its right and left in the same order
        if (current == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.data + " ");
            // right then left coz it's a stack
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }

    }

    public static void postOrder_Iterative(Node current) {
        // tricky?
    }
}

class Node {

    public Node right;
    public int data;
    public Node left;
}
