package DSA.Trees;

import java.util.List;

// given node1 and node2 in a Binary tree, print path between the nodes
public class PathBetweenNodes {
    public static void main(String[] args) {
        int[] elements = new int[]{20, 30, 34, 9, 28, 5, 17, 6, 7, 1, 33, 29, 16, 42, 56, 2, 58, 60};
        BinarySearchTreeOps bst = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = bst.buildTree(elements);

        printPath_BST(root, 9, 28);
        printPath_BST(root, 7, 60);
        printPath_BST(root, 9, 16);
        printPath_BST(root, 33, 58);
        printPath_BST(root, 20, 33);
        printPath_BST(root, 29, 33);
        printPath_BST(root, 2, 22);
        printPath_BST(root, 23, 22);

    }

    private static void printPath_BST(BinaryTreeOps.TreeNode root, int key1, int key2) {
        if(root == null) {
            return;
        }

        System.out.printf("\nPath from %d to %d: \n", key1, key2);

        List<BinaryTreeOps.TreeNode> path1 = BinarySearchTreeOps.getPath_BST(root, key1);
        List<BinaryTreeOps.TreeNode> path2 = BinarySearchTreeOps.getPath_BST(root, key2);

        BinaryTreeOps.TreeNode lca = LCABST.getLCAFromPaths(path1, path2);

        if(lca.data == -1) {
            System.out.println("No path exists");
            return;
        }

        int index1 = path1.indexOf(lca);
        int index2 = path2.indexOf(lca);

        // print until lca from the end
        for(int i= path1.size()-1; i>index1; i--) {
            System.out.print(path1.get(i).data + " ");
        }

        // print lca
        System.out.print(lca.data + " ");

        // print from lca
        for(int i= index2+1; i<path2.size(); i++) {
            System.out.print(path2.get(i).data + " ");
        }

        System.out.println();
    }

}
