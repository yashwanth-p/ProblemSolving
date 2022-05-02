package DSA.Trees;

public class SumProblems {
    static int maxPathSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] elements = {10, -2, 7, 8, -4};
        BinaryTree tree = new BinaryTree();
        Node rootNode = tree.buildLevelOrderTree(elements);
        tree.printLevelOrder();
        printMaxRootToLeafSum(rootNode);
    }

    private static void printMaxRootToLeafSum(Node rootNode) {
        if(rootNode==null) return;
        maxRootToLeafSum(rootNode, rootNode.data);
        System.out.println("\n Maximum root to leaf path sum: " + maxPathSum);
    }

    private static void maxRootToLeafSum(Node root, int sumSoFar) {
        if (root==null) return;
        if(isLeaf(root)) {
            if(sumSoFar > maxPathSum) {
                maxPathSum = sumSoFar;
            }
            return;
        }
        if(root.left!=null) {
            maxRootToLeafSum(root.left, sumSoFar+root.left.data);
        }
        if(root.right!=null) {
            maxRootToLeafSum(root.right, sumSoFar+root.right.data);
        }
    }

    private static boolean isLeaf(Node root) {
        return  root!=null && root.left==null && root.right==null;
    }



}