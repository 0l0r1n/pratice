import java.util.HashSet;

class RemoveDuples {

    void remove(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while (n != null) {
            if (set.contains(n.data)) previous.next = n.next;
            set.add(n.data);
            previous = n;
            n = n.next;
        }
    }

}