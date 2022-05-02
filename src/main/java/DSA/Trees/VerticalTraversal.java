package DSA.Trees;

import java.util.*;

public class VerticalTraversal {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 9, 28, 30, 34, 33, 29, 42, 56, 58, 60, 25, 24};
        BinarySearchTreeOps tree = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = tree.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        System.out.println();
        printVerticalTraversal(root);

        printVerticalTraversal_Optimized(root);


        elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinaryTreeOps binaryTree = new BinaryTreeOps(elements);
        LevelOrderTraversal.printLevelWiseElements(binaryTree.getRoot());

        System.out.println();
        printVerticalTraversal(binaryTree.getRoot());
    }

    // TODO: solve in O(N) time
    private static void printVerticalTraversal_Optimized(BinaryTreeOps.TreeNode root) {

    }

    // O(NLogN) => For TreeMap operations
    // S(N) => For TreeMap
    private static void printVerticalTraversal(BinaryTreeOps.TreeNode root) {
        Map<Integer, List<Integer>> levelToNodes = new TreeMap<>();
        traverseAndAddVerticalLevelElements(root, 0, levelToNodes);
        printMap(levelToNodes);
    }

    private static void printMap(Map<Integer, List<Integer>> levelToNodes) {
        for (Map.Entry<Integer, List<Integer>> current : levelToNodes.entrySet()) {
            for(int data : current.getValue()) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    // add all the nodes at horizontal distance 'x' from root to a Map
    // TreeMap to maintain the sort order
    private static void traverseAndAddVerticalLevelElements(BinaryTreeOps.TreeNode root, int hzDistance, Map<Integer, List<Integer>> levelToNodes) {
        if (root == null) {
            return;
        }
        addToMap(root.data, hzDistance, levelToNodes);
        traverseAndAddVerticalLevelElements(root.left, hzDistance - 1, levelToNodes);
        traverseAndAddVerticalLevelElements(root.right, hzDistance + 1, levelToNodes);

    }

    private static void addToMap(int data, int hzDistance, Map<Integer, List<Integer>> levelToNodes) {
        List<Integer> list = levelToNodes.computeIfAbsent(hzDistance, k -> new ArrayList<>());
        list.add(data);
    }
}
