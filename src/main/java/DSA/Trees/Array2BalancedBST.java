package DSA.Trees;

import java.util.Arrays;
import java.util.List;

public class Array2BalancedBST {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{20,21,23,45,65,66,70,98,99,109,110,165,180};
        BinaryTreeOps.TreeNode root = buildAndGetBalancedBST(Arrays.asList(arr), 0, arr.length-1);
        LevelOrderTraversal.printLevelWiseElements(root);

        DSA.Trees.BinarySearchTreeOps.printInorder(root);
    }

    public static BinaryTreeOps.TreeNode buildAndGetBalancedBST(List<Integer> arr, int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = (l+r)/2;
        BinaryTreeOps.TreeNode node = new BinaryTreeOps.TreeNode(arr.get(mid));
        node.left = buildAndGetBalancedBST(arr, l, mid-1);
        node.right = buildAndGetBalancedBST(arr, mid+1, r);

        return node;
    }

    /*private static void dummyCheckIfTreeIsBalanced() {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinaryTree binaryTree = new BinaryTree(elements);
        LevelOrderTraversal.printLevelWiseElements(binaryTree.getRoot());

        boolean isBalanced = TreeUtils.checkIfTreeIsBalanced(binaryTree.getRoot());
        System.out.println("Is tree balanced: " + isBalanced);

        System.out.println();

        elements = new int[]{20, 9, 28, 30, 34, 33, 29, 42, 25, 24, 15, 6, 4};
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        isBalanced = TreeUtils.checkIfTreeIsBalanced(root);
        System.out.println("Is tree balanced: " + isBalanced);
        System.out.println();
    }*/
}
