class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 0; i <= n; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) { 
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}