package DSA.Trees;

public class TreeUtils {

    public static boolean checkIfTreeIsBalanced(BinaryTreeOps.TreeNode root) {
        BalancedWrapper wrapper = new BalancedWrapper();
        checkAndSetHeightBalanced(root, wrapper);
        return wrapper.isBalanced;
    }

    private static int checkAndSetHeightBalanced(BinaryTreeOps.TreeNode root, BalancedWrapper wrapper) {
        if(root == null) {
            return 0;
        }
        int left = checkAndSetHeightBalanced(root.left, wrapper);
        if(!wrapper.isBalanced) return -1; // once found send the sign not to traverse further. looks ugly, though

        int right = checkAndSetHeightBalanced(root.right, wrapper);

        if(Math.abs(left-right) > 1) {
            System.out.println("Diff: " + Math.abs(left-right) + " left: "+root.left.data + " right: "+root.right.data);
            wrapper.isBalanced = false;
            return -1;
        }
        return Math.max(left, right)+1;
    }


    private static class BalancedWrapper {
        boolean isBalanced = true;
    }
}


