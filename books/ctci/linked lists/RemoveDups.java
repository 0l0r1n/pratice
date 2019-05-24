public class RemoveDups {
    
    public static Node solveWithHashSet(Node n) {
        Node head = n;
        HashSet<Integer> found = new HashSet<>();
        Node prev = n;
        for (Node pointer = n; pointer != n; pointer = pointer.next) {
            if (found.countains(n.val) && n.next != null) {
                prev.next = n.next.next;
            }  else {
                found.add(n.val);
                prev = n.next;
            }
        }
        return head;
    }

    public static Node solveWithoutBuffer(Node n) {
        Node head = n;
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