package DSA.Trees;

import java.util.List;

public class LCABinaryTree {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 12, 13, 28, 9, 5, 14, 6, 7, 1, 33, 29, 16, 42, 56, 2, 58, 60};
        DSA.Trees.BinaryTreeOps tree = new DSA.Trees.BinaryTreeOps(elements);
        BinaryTreeOps.TreeNode root = tree.getRoot();

        LevelOrderTraversal.printLevelWiseElements(root);
        printLCA(root, 56, 29);
        printLCA(root, 16, 29);
        printLCA(root, 7, 16);
        printLCA(root, 16, 9);
        printLCA(root, 42, 56);
        printLCA(root, 9, 99);
    }

    private static void printLCA(BinaryTreeOps.TreeNode root, int key1, int key2) {
        System.out.println();
        BinaryTreeOps.TreeNode lca = getLCA(root, key1, key2);
        System.out.printf("LCA of %d and %d is %s", key1, key2, lca.data);
    }

    // O(N) - requires visiting the all the nodes
    // S(h) - 2 intermediate collections to store the path
    private static BinaryTreeOps.TreeNode getLCA(BinaryTreeOps.TreeNode root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        List<BinaryTreeOps.TreeNode> path1 = DSA.Trees.BinaryTreeOps.getPath(root, key1);
        List<BinaryTreeOps.TreeNode> path2 = DSA.Trees.BinaryTreeOps.getPath(root, key2);

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
