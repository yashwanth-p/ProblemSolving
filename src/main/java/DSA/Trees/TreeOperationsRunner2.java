package DSA.Trees;

public class TreeOperationsRunner2 {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 30, 34, 9, 28, 5, 17, 6};

        // binary search tree
        BinarySearchTreeOps bst = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = bst.buildTree(elements);
        BinarySearchTreeOps.printInorder(root);

        System.out.println("Height: " + bst.getHeight(root));
        bst.insertNode(root, 7);
        bst.insertNode(root, 1);
        BinarySearchTreeOps.printInorder(root);
        System.out.println("Height: " + bst.getHeight(root));

        System.out.println("Leaves: " + bst.getLeafCount(root));

//        root = bst.deleteNode(root, 6);

        LevelOrderTraversal.printLevelWiseElements(root);
        LevelOrderTraversal.printLevelWiseElements_Mirror(root);
        LevelOrderTraversal.printLevelWiseElements(MirrorTree.getMirrorTree(root));


    }
}
