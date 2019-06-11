public class BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)); 
        if (diff > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root, int height) {
        if (root == null) return -1;
        else return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
    }
}