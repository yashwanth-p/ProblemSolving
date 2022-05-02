package DSA.Trees;

import java.util.Stack;

public class TraversalUtils {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root1 = tree.getASampleTree();
        iterative(root1);
        recursive(root1);
        printRootToLeafPaths_Iterative();

    }

    // TODO :
    public static void printRootToLeafPaths_Iterative() {
    }

    public static void recursive(Node root1) {
        System.out.println("\nInorder Recursive:");
        inorder_rec(root1);
        System.out.println("\nPreOrder Recursive:");
        preorder_rec(root1);
        System.out.println("\nPostOrder Recursive:");
        postorder_rec(root1);
    }

    public static void postorder_rec(Node current) {
        if (current != null) {
            postorder_rec(current.left);
            postorder_rec(current.right);
            System.out.print(current.data + " ");
        }
    }

    public static void preorder_rec(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorder_rec(current.left);
            preorder_rec(current.right);
        }
    }

    public static void inorder_rec(Node current) {
        if (current != null) {
            inorder_rec(current.left);
            System.out.print(current.data + " ");
            inorder_rec(current.right);
        }
    }

    public static void iterative(Node root1) {
        inorder_Iterative(root1);
        preOrder_Iterative(root1);
        postOrder_Iterative(root1);
    }

    public static void postOrder_Iterative(Node current) {
        System.out.println();
        System.out.println("PostOrder traversal : Iterative ");
        if (current == null) return;

        Stack<Node> stack = new Stack<>();
        Stack<Node> reversePostOrderStack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            reversePostOrderStack.push(current);
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }

        printAndClearStack(reversePostOrderStack);
    }

    public static void printAndClearStack(Stack<Node> reversePostOrderStack) {
        while (!reversePostOrderStack.isEmpty()) {
            System.out.print(reversePostOrderStack.pop().data + " ");
        }
    }

    public static void preOrder_Iterative(Node current) {
        System.out.println();
        System.out.println("PreOrder traversal : Iterative ");
        if (current == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }

    }

    public static void inorder_Iterative(Node current) {
        System.out.println();
        System.out.println("InOrder traversal : Iterative ");
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


}
