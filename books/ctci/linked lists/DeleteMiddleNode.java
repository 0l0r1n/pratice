public class DeleteMiddleNode {

    public static void solve(Node n) {
        if (n == null || n.next == null) return;
        n.val = n.next.val;
        n.next = n.next.next;
    }

    public class Node {

        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}