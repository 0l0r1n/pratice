public class ListOfDepths {

    public static ArrayList<LinkedList<TreeNode>> solve(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList();
        createLists(root, result, 0);
        return result;
    }

    private static void createLists(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLists(root.left, lists, level + 1);
        createLists(root.right, lists, level + 1);
    }
}