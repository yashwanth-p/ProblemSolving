package DSA.Trees;

import java.util.List;

public class LCABST {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 30, 34, 9, 28, 5, 17, 6, 7, 1, 33, 29, 16, 42, 56, 2, 58, 60};
        BinarySearchTreeOps bst = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = bst.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        printLCA(root, 56, 29);
        printLCA(root, 16, 29);
        printLCA(root, 7, 16);
        printLCA(root, 16, 9);
        printLCA(root, 42, 56);
        printLCA(root, 9, 16);
        printLCA(root, 9, 99);


    }

    private static void printLCA(BinaryTreeOps.TreeNode root, int key1, int key2) {
        System.out.println();
        BinaryTreeOps.TreeNode lca = getLCA_BST(root, key1, key2);
        System.out.printf("LCA of %d and %d is %s", key1, key2, lca.data);
    }


    // O(height) AND S(h) - 2 intermediate collections
    public static BinaryTreeOps.TreeNode getLCA_BST(BinaryTreeOps.TreeNode root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        List<BinaryTreeOps.TreeNode> path1 = BinarySearchTreeOps.getPath_BST(root, key1);
        List<BinaryTreeOps.TreeNode> path2 = BinarySearchTreeOps.getPath_BST(root, key2);

        return getLCAFromPaths(path1, path2);
    }

    public static BinaryTreeOps.TreeNode getLCAFromPaths(List<BinaryTreeOps.TreeNode> path1, List<BinaryTreeOps.TreeNode> path2) {
        if (path1 == null || path2 == null) {
            return new BinaryTreeOps.TreeNode(-1);
        }
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i - 1);
    }

}
