package DSA.Trees;

public class BSTTraversals {
    private static Node root;

    public static void main(String[] args) {
        BinaryTree bst = new BinarySearchTree();
        root = bst.buildTree(new int[]{20, 18, 16, 13, 25, 23, 28, 19});
        printInOrder();
        root = bst.delete(18);
        printInOrder();
        printPreOrder();
        printPostOrder();
    }


    private static void printInOrder() {
        System.out.println();
        TraversalUtils.inorder_rec(root);
    }

    private static void printPreOrder() {
        System.out.println();
        TraversalUtils.preorder_rec(root);
    }

    private static void printPostOrder() {
        System.out.println();
        TraversalUtils.postorder_rec(root);
    }
}
