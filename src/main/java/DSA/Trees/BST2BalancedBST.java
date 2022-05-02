package DSA.Trees;

import java.util.ArrayList;
import java.util.List;

public class BST2BalancedBST {
    public static void main(String[] args) {
        int[] elements = new int[]{30, 20, 10};
        BinarySearchTreeOps tree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        System.out.println();

        naiveApproach(root); // looks like this is the better possible approach

        /* Ideas:
        * BST => DLL(Inplace) => Balanced BST
        * */

    }

    private static void naiveApproach(BinaryTreeOps.TreeNode root) {
        /* Inorder traversal and store it in array -- O(n) and S(n) - recursive stack
        * Build a NEW balanced BST out of inorder array -- O(n) + S(n)
        *
        * Total: O(n) and S(2n)
        * */
        List<Integer> inorder = new ArrayList<>();
        fillInorderList(root, inorder);
        BinaryTreeOps.TreeNode newRoot = Array2BalancedBST.buildAndGetBalancedBST(inorder, 0, inorder.size()-1);
        LevelOrderTraversal.printLevelWiseElements(newRoot);
        BinarySearchTreeOps.printInorder(newRoot);
    }

    private static void fillInorderList(BinaryTreeOps.TreeNode current, List<Integer> inorder) {
        if(current == null) {
            return;
        }
        fillInorderList(current.left, inorder);
        inorder.add(current.data);
        fillInorderList(current.right, inorder);
    }
}
