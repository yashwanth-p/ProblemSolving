package DSA.Trees;

public class IdenticalTrees {
    public static void main(String[] args) {
        BinaryTreeOps tree1 = new BinaryTreeOps(new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10});
        BinaryTreeOps tree2 = new BinaryTreeOps(new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10});
        BinaryTreeOps tree3 = new BinaryTreeOps(new int[]{1});
        BinaryTreeOps tree4 = new BinaryTreeOps(new int[]{1, 3, 4, 6, 8, 16 ,7, 32, 19, 10});

        System.out.println("Are Trees 1 & 2 " + areIdentical(tree1.root, tree2.root));
        System.out.println("Are Trees 1 & 3 " + areIdentical(tree1.root, tree3.root));
        System.out.println("Are Trees 1 & 4 " + areIdentical(tree1.root, tree4.root));

    }

    public static  boolean areIdentical(BinaryTreeOps.TreeNode root1, BinaryTreeOps.TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(!conditionsMet(root1, root2)) {
            return false;
        }
        return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    private static boolean conditionsMet(BinaryTreeOps.TreeNode root1, BinaryTreeOps.TreeNode root2) {
        if((root1 == null || root2 == null)) {
            return false;
        }
        return root1.data == root2.data;
    }
}
