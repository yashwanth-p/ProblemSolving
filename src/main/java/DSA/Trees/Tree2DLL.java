package DSA.Trees;

public class Tree2DLL {
    private static BinaryTreeOps.TreeNode head = null;
    private static BinaryTreeOps.TreeNode previous = null;
    public static void main(String[] args) {
        int[] elements = new int[]{20, 12, 13, 28, 9, 5, 14, 6, 7, 1, 33, 29, 16, 42, 56, 2, 58, 60};
        BinaryTreeOps tree = new BinaryTreeOps(elements);
        BinaryTreeOps.TreeNode root = tree.getRoot();

        LevelOrderTraversal.printLevelWiseElements(root);
        tree.printInOrder(root);

        convertTreeToDLL(root);
    }

    private static void convertTreeToDLL(BinaryTreeOps.TreeNode root) {
        convertTreeToDLLInner(root);
        printDLL(head);
    }

    private static void printDLL(BinaryTreeOps.TreeNode head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    private static void convertTreeToDLLInner(BinaryTreeOps.TreeNode root) {
        if(root == null) {
            return;
        }
        convertTreeToDLLInner(root.left);
        if(previous == null) {
            head = root;
        } else {
            previous.right = root;
            root.left = previous;
        }
        previous = root;
        convertTreeToDLLInner(root.right);
    }
}
