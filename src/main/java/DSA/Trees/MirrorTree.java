package DSA.Trees;

public class MirrorTree {
    // source: https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
    public static void main(String[] args) {
        BinaryTreeOps tree = new BinaryTreeOps(new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10, 21});
        // get a new mirror tree
        BinaryTreeOps.TreeNode mirrorNode = getMirrorTree(tree.getRoot());
        LevelOrderTraversal.printLevelWiseElements(mirrorNode);

        // print a mirror tree without modifying tree
        LevelOrderTraversal.printLevelWiseElements_Mirror(tree.getRoot());

    }

    public static BinaryTreeOps.TreeNode getMirrorTree(BinaryTreeOps.TreeNode root) {
        if(root == null) {
            return null;
        }

        // getting then swapping is important
        BinaryTreeOps.TreeNode left = getMirrorTree(root.left);
        BinaryTreeOps.TreeNode right = getMirrorTree(root.right);

       /*
        Instead of getting and swapping. This will not work
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
       */
        root.left = right;
        root.right = left;

        return root;
    }
}
