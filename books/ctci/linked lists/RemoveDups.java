public class RemoveDups {
    
    // takes  O(n) space and time where n is the length of the linked list
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

    // would  take O(1) space but O(N^2) time
    public static Node solveWithoutBuffer(Node n) {
        Node head = n;
        for (Node p1 = n; p1 != n; p1 = p1.next) {
            for (Node p2 = p1.next; p2 != n; p2 = p2.next) {
                if (p1.val == p2.val) {
                    p1.next = p2.next;
                }
            }
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