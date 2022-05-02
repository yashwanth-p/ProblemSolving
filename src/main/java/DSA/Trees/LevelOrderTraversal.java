package DSA.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeOps tree = new BinaryTreeOps(new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10, 21});
        BinaryTreeOps tree2 = new BinaryTreeOps(new int[]{1});
        printLevelOrder(tree.getRoot());
        printLevelWiseElements(tree.getRoot());
        printLevelWiseElements(tree2.getRoot());
    }

    public static void printLevelOrder(BinaryTreeOps.TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<BinaryTreeOps.TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            BinaryTreeOps.TreeNode cur = q.poll();
            System.out.println(cur.data);
            if(cur.left != null) {
                q.add(cur.left);
            }
            if(cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    public static void printLevelWiseElements(BinaryTreeOps.TreeNode root) {
        System.out.println("\nLevel order traversal");
        int levels = 0;
        if(root == null) {
            return;
        }
        Queue<BinaryTreeOps.TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size()>1){
            BinaryTreeOps.TreeNode cur = q.poll();
            // marker element
            if(cur == null) {
                System.out.println();
                q.add(null);
                levels++;
                continue;
            }
            System.out.print(cur.data + " ");

            if(cur.left != null) {
                q.add(cur.left);
            }
            if(cur.right != null) {
                q.add(cur.right);
            }
        }
        System.out.println("\nHeight: " + levels);
    }

    public static void printLevelWiseElements_Mirror(BinaryTreeOps.TreeNode root) {
        System.out.println("\nReverse level order traversal");
        int levels = 0;
        if(root == null) {
            return;
        }
        Queue<BinaryTreeOps.TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size()>1){
            BinaryTreeOps.TreeNode cur = q.poll();
            // marker element
            if(cur == null) {
                System.out.println();
                levels++;
                q.add(null);
                continue;
            }
            System.out.print(cur.data + " ");

            // order of insertion flipped
            if(cur.right != null) {
                q.add(cur.right);
            }
            if(cur.left != null) {
                q.add(cur.left);
            }
        }

        System.out.println("\nHeight: " + levels);
    }

    public static void printNodesAtLevel(BinaryTreeOps.TreeNode root, int levelToPrint) {
        if(root == null) {
            return;
        }

        System.out.println("\nElements at level: "+levelToPrint);
        int levels = 0;

        Queue<BinaryTreeOps.TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size()>1){
            BinaryTreeOps.TreeNode cur = q.poll();
            // marker element
            if(cur == null) {
                levels++;
                q.add(null);
                continue;
            }

            if(levelToPrint == levels) {
                System.out.println(cur.data);
            }

            if(cur.left != null) {
                q.add(cur.left);

            }

            if(cur.right != null) {
                q.add(cur.right);
            }

        }
    }
}
