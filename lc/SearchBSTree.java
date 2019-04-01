class SearchBSTree { 

    public static TreeNode solve(TreeNode root, int val) {
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            TreeNode current = q.poll();
            if (visited.contains(current)) continue;
            if (current == null) continue;
            visited.add(current);
            if (current.val == val) return current;
            else {
                q.add(current.left);
                q.add(current.right);
            }
        }
        return null;
    }
    
}