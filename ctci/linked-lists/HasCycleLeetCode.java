public class HasCycleLeetCode {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> processed = new HashSet<ListNode>();
        ListNode n = head;
        while (n != null) {
            if (processed.contains(n)) return true;
            processed.add(n);
            n = n.next;
        }
        return false;
    }
    
}