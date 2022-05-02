package DSA.Trees;

public class LevelOfKey {
    public static void main(String[] args) {
        // approach:1
        // Iterate using level order, note the levels of traversal
        // return the level if element is found.
        // O(N) - S(N) for maintaining the queue

        int[] elements = new int[]{20, 30, 34, 9, 28, 5, 17, 6, 7, 1};
        BinarySearchTreeOps bst = new BinarySearchTreeOps();
        BinaryTreeOps.TreeNode root = bst.buildTree(elements);
        LevelOrderTraversal.printLevelWiseElements(root);

        System.out.println();

        System.out.println("Level of 9 : " + getLevel(root, 9));
        System.out.println("Level of 10 : " + getLevel(root, 10));
        System.out.println("Level of 7 : " + getLevel(root, 7));
        System.out.println("Level of 17 : " + getLevel(root, 17));

        System.out.println();

        printLevelForEachNode(root, 0);

        System.out.println();

        // finding level of a key: given BST
        System.out.println("Level of 9 : " + getLevel_BST(root, 9));
        System.out.println("Level of 10 : " + getLevel_BST(root, 10));
        System.out.println("Level of 7 : " + getLevel_BST(root, 7));
        System.out.println("Level of 17 : " + getLevel_BST(root, 17));

    }

    // O(height) S(1) - No temp data needed
    private static int getLevel_BST(BinaryTreeOps.TreeNode root, int key) {
        BinaryTreeOps.TreeNode temp = root;
        int level = -1;
        while(temp != null) {
            level++;
            if(key == temp.data) {
                return level;
            }
            // choose either of the paths
            if(key < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return -1;
    }

    private static void printLevelForEachNode(BinaryTreeOps.TreeNode root, int level) {
        if(root == null) {
            return;
        }
        System.out.println("Node: " + root.data + " Level: "+ level);
        printLevelForEachNode(root.left, level+1);
        printLevelForEachNode(root.right, level+1);

    }

    // O(N) S(height)
    public static int getLevel(BinaryTreeOps.TreeNode root, int key) {
        if(root == null) {
            return -1;
        }
        Level level = new Level();
        setLevel(root, key, level, 0);

        return level.level;
    }

    private static void setLevel(BinaryTreeOps.TreeNode root, int key, Level level, int currentLevel) {
        if(root == null) return;

        if(key == root.data) {
            level.level = currentLevel;
            return;
        }
        setLevel(root.left, key, level, currentLevel+1);
        setLevel(root.right, key, level, currentLevel+1);
    }


    private static class Level {
        int level = -1;
    }
}
