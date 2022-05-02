package DSA.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeOps {

    public BinaryTreeOps.TreeNode buildTree(int[] elements) {
        BinaryTreeOps.TreeNode root = null;
        System.out.println("Insertion order");
        for (int e : elements) {
            System.out.print(e + " ");
            root = insertNode(root, e);
        }
        System.out.println();
        return root;
    }

    public BinaryTreeOps.TreeNode insertNode(BinaryTreeOps.TreeNode current, int e) {
        if (current == null) {
            return new BinaryTreeOps.TreeNode(e);
        }
        if(e < current.data) {
            current.left = insertNode(current.left, e);
        } else {
            current.right = insertNode(current.right, e);
        }
        return current;
    }


    // O(h) h=height
    // S(h) - for call stack
    public static void printInorder(BinaryTreeOps.TreeNode root) {
        System.out.println("\nInorder traversal");
        printInorderInner(root);
        System.out.println();
    }

    private static void printInorderInner(BinaryTreeOps.TreeNode root) {
        if(root == null) return;
        printInorderInner(root.left);
        System.out.print(root.data + " ");
        printInorderInner(root.right);
    }

    // O(N) => requires visiting every node
    public int getHeight(BinaryTreeOps.TreeNode root) {
        if(root == null) return -1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight+1, rightHeight+1);
    }

    public int getLeafCount(BinaryTreeOps.TreeNode root) {
        LeafCounter counter = new LeafCounter();
        updateLeafCount(root, counter);
        return counter.getLeafCount();
    }

    private void updateLeafCount(BinaryTreeOps.TreeNode root, LeafCounter counter) {
        if(root == null) {
            return;
        }
        updateLeafCount(root.left, counter);
        if(isLeafNode(root)) {
            counter.incrementCount();
        }
        updateLeafCount(root.right, counter);
    }

    private boolean isLeafNode(BinaryTreeOps.TreeNode root) {
        return root.left == null && root.right == null;
    }

    // TODO
    public BinaryTreeOps.TreeNode deleteNode(BinaryTreeOps.TreeNode root, int key) {
        return null;
    }

    // Alternative to C-type passby reference
    private static class LeafCounter {
        int leaves = 0;

        public void incrementCount() {
            leaves++;
        }

        public int getLeafCount() {
            return leaves;
        }
    }

    public static BinaryTreeOps.TreeNode findKeyInBST(BinaryTreeOps.TreeNode root, int key) {
        BinaryTreeOps.TreeNode temp = root;

        while(temp!=null) {
            if(key == temp.data) {
                return temp;
            }
            if(key < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public static List<BinaryTreeOps.TreeNode> getPath_BST(BinaryTreeOps.TreeNode root, int key) {
        List<BinaryTreeOps.TreeNode> path = new ArrayList<>();
        BinaryTreeOps.TreeNode temp = root;
        while(temp != null) {
            path.add(temp);
            if(temp.data == key) {
                return path;
            }
            if(key < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }
}

