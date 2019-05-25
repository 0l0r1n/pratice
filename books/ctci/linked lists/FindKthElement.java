public class FindKthElement {

    public static int solveRecursevily(Node n, int k) {
        if (n == null) return 0;
        return solveRecursevily(n.next, k) + 1;
    }

    public static int solveIteratively(Node n, int k) {
        Node p1 = n;
        Node p2 = n;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return -1;
            p = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.val;
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