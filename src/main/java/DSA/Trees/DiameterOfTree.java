package DSA.Trees;

public class DiameterOfTree {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 9, 28, 30, 34, 5, 17, 6, 7, 1, 33, 29, 16, 42, 56, 2, 58, 60};
        BinarySearchTreeOps tree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);
        int diameter = getDiameterUtil(root);
        System.out.println("Tree1 Diameter: " + diameter);

        elements = new int[]{20, 9, 28, 30, 34, 33, 29, 42, 56, 58, 60, 25, 24};
        tree = new BinarySearchTreeOps();
        root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);
        diameter = getDiameterUtil(root);
        System.out.println("Tree2 Diameter: " + diameter);
    }

    private static int getDiameterUtil(BinaryTreeOps.TreeNode root) {
        Diameter d = new Diameter();
        int height = getDiameter(root, d);
        System.out.println("Calculated height: " + height);
        return d.max_diameter;
    }

    // Diameter = a node with max_sum(LST, RST)
    // this is like a typical height calculation with additional logic for evaluating above.
    private static int getDiameter(BinaryTreeOps.TreeNode root, Diameter d) {
        if (root == null) {
            return -1;
        }
        int left_height = getDiameter(root.left, d) + 1;
        int right_height = getDiameter(root.right, d) + 1;

        // max_sum(LST, RST)
        int currentNodeDiameter = left_height + right_height;
        if (currentNodeDiameter > d.max_diameter) {
            d.max_diameter = currentNodeDiameter;
        }

        return Math.max(left_height, right_height);
    }

    private static class Diameter {
        int max_diameter = Integer.MIN_VALUE;
    }
}
