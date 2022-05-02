package DSA.Trees;

public class SubsetTree {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 9, 28, 30, 34, 5, 17, 6, 7, 1, 33, 29, 16, 42, 56, 2};
        BinarySearchTreeOps tree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        System.out.println();

        elements = new int[]{34, 42, 56};
        BinarySearchTreeOps subTree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode subRoot = subTree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(subRoot);

        System.out.println();

        boolean isSubset = isSubtree(subRoot, root);
        System.out.println(isSubset);

    }

    // TODO: should part of the tree be considered subtree? (perhaps, no)
    private static boolean isSubtree(BinaryTreeOps.TreeNode subRoot, BinaryTreeOps.TreeNode root) {
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        // find the root of the subtree in the main tree
        // check if the subtree is identical to actual subtree from main tree
        // TODO: what if there are duplicate elements? Refer the problem from CTCI
        BinaryTreeOps.TreeNode actualSubroot = BinarySearchTreeOps.findKeyInBST(root, subRoot.data);
        if(actualSubroot  == null){
            return false;
        }

        return  IdenticalTrees.areIdentical(actualSubroot, subRoot);
    }
}
