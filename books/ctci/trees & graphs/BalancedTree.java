public class BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)); 
        if (diff > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    public static boolean isBalancedFast(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private static int getHeight(TreeNode root, int height) {
        if (root == null) return -1;
        else return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) return false;
        return Maxh.max(leftHeight, rightHeight) - 1;
    }

}