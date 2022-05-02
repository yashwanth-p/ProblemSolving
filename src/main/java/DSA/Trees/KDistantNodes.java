package DSA.Trees;

// print all the nodes that are at a distance k "down" from the given node.
public class KDistantNodes {

    public static void main(String[] args) {
        int[] elements = new int[]{20, 30, 34, 9, 28, 5, 17, 6, 7, 1, 33, 29, 16, 42, 56, 2};
        BinarySearchTreeOps bst = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = bst.buildTree(elements);

        LevelOrderTraversal.printLevelWiseElements(root);

        kDistantNodesFromRoot(root, 3);
        kDistantNodesFromRoot(root, 0);
        kDistantNodesFromRoot(root, 5);

        kDistantNodesFromKey(root, 19, 2); // define properly
        kDistantNodesFromKey(root, 9, 3); // define properly

    }

    private static void kDistantNodesFromRoot(BinaryTreeOps.TreeNode root, int k) {
        System.out.println();
        // from root 'k' distant nodes are at 'kth' level
        LevelOrderTraversal.printNodesAtLevel(root, k);
    }

    private static void kDistantNodesFromKey(BinaryTreeOps.TreeNode root, int key, int k) {
        System.out.println();
        BinaryTreeOps.TreeNode keyNode = BinarySearchTreeOps.findKeyInBST(root, key);
        if(keyNode == null) {
            System.out.printf("Key %d not found in the tree", key);
            return;
        }
        System.out.printf("\nFrom key %d", key);
        LevelOrderTraversal.printNodesAtLevel(keyNode, 3);
    }
}
