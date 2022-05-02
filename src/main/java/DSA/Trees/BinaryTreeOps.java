package DSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeOps {


    Queue<TreeNode> q = new LinkedList<>();

    public TreeNode getRoot() {
        return root;
    }

    TreeNode root;

    public BinaryTreeOps(int[] elements) {
        generateTree(elements);
    }

    private void generateTree(int[] elements) {
        for(int e : elements) {
             insertNode(e);
        }
    }

    private void insertNode(int e) {
        TreeNode node = new TreeNode(e);
        if(q.isEmpty()) {
            q.add(node);
            root = node;
            return;
        }
        TreeNode top = q.peek();
        if(top.left == null) {
            top.left = node;
        } else if(top.right == null) {
            top.right = node;
        }
        q.add(node);
        // remove if not potential parent
        if(top.right !=null) {
            q.poll();
        }

    }

    public void printInOrder(TreeNode root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }
    }

    public static List<TreeNode> getPath(TreeNode root, int key) {

        PathWrapper wrapper = new PathWrapper();

        setPathFromRoot(root, wrapper, key);
        return wrapper.path.size() == 0 ? null : wrapper.path;
    }

    private static void setPathFromRoot(TreeNode root, PathWrapper wrapper, int key) {
        // unnecessarily do not visit if the key found
        if (root == null || wrapper.isKeyFound) {
            return;
        }

        wrapper.path.add(root);
        if (root.data == key) {
            wrapper.isKeyFound = true;
            return;
        }

        setPathFromRoot(root.left, wrapper, key);
        setPathFromRoot(root.right, wrapper, key);

        // no need for this to be collected
        if (!wrapper.isKeyFound) {
            wrapper.path.remove(root);
        }
    }

    private static class PathWrapper {
        private final List<TreeNode> path;
        private boolean isKeyFound;

        public PathWrapper() {
            this.path = new ArrayList<>();
            isKeyFound = false;
        }
    }


    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int e) {
            this.data = e;
        }
    }
}
