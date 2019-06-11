import BinaryTree.Node;

public class MinimalTree {

    public static Node build(int[] values) {
        return build(values, 0, values.length - 1);
    }

    private static Node build(int[] values, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        Node root = new Node(values[mid]);
        root.left = build(values, start, mid - 1);
        root.right = build(values, mid + 1, end);
        return root;
    }
}