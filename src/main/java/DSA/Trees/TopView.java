package DSA.Trees;

import java.util.Map;
import java.util.TreeMap;

// FIXME: Buggy implementation
public class TopView {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 9, 28, 30, 34, 33, 29, 42, 56, 58, 60, 25, 24};
        BinarySearchTreeOps tree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        System.out.println();
        printTopView(root);


        elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinaryTreeOps binaryTree = new BinaryTreeOps(elements);
        LevelOrderTraversal.printLevelWiseElements(binaryTree.getRoot());

        System.out.println();
        printTopView(binaryTree.getRoot());
    }

    // Top view is the collection of first vertical elements
    private static void printTopView(BinaryTreeOps.TreeNode root) {
        System.out.println("Top view of the tree");
        Map<Integer, Integer> levelToFirstNode = new TreeMap<>();
        traverseAndAddFirstVerticalElements(root, 0, levelToFirstNode);
        printMap(levelToFirstNode);
    }

    private static void traverseAndAddFirstVerticalElements(BinaryTreeOps.TreeNode root, int hzDistance, Map<Integer, Integer> levelToFirstNode) {
        if (root == null) {
            return;
        }
        levelToFirstNode.putIfAbsent(hzDistance, root.data);
        traverseAndAddFirstVerticalElements(root.left, hzDistance - 1, levelToFirstNode);
        traverseAndAddFirstVerticalElements(root.right, hzDistance + 1, levelToFirstNode);
    }

    private static void printMap(Map<Integer, Integer> levelToFirstNode) {
        for (Map.Entry<Integer, Integer> entry : levelToFirstNode.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }
}
