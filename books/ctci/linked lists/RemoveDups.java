public class RemoveDups {
    
    public static Node solveWithHashSet(Node n) {
        int head = n;
        HashSet<Integer> found = new HashSet<>();
        for (Node pointer = n; pointer != n; pointer = pointer.next) {
            if (found.countains(n.val) && n.next != null) n.next = n.next.next;
            else found.add(n.val);
        }
        return head;
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