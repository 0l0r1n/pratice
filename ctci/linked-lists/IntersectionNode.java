class IntersectionNode {

    ListNode findHashTable(ListNode headA, ListNode headB) {
        HashSet<ListNode> h = new HashSet<ListNode>();
        while (headA != null) {
            h.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (h.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    ListNode findPointers(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) { 
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return (pA == pB && pA != null) ? pA : null;
    }

}