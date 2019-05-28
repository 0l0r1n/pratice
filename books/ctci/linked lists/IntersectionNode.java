public class IntersectionNode {

    public ListNode solveWithHashSet(ListNode headA, ListNode headB) {
        HashSet<ListNode> s = new HashSet();
        for (ListNode pointer = headA; pointer != null; pointer = pointer.next) s.add(pointer);
        for (ListNode pointer = headB; pointer != null; pointer = pointer.next) {
            if (s.contains(pointer)) return pointer;
        }   
        return null;
    }

    public ListNode solveWithoutExtraMemory(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        int length1 = 0;
        int length2 = 0;
        ListNode pointer1;
        ListNode pointer2;
        for (pointer1 = headA; pointer1.next != null; pointer1 = pointer1.next) length1++;
        for (pointer2 = headB; pointer2.next != null; pointer2 = pointer2.next) length2++;
        if (pointer1 != pointer2) return null;
        
        ListNode shorter = length1 < length2 ? headA : headB;
        ListNode longer = length1 < length2 ? headB : headA;
        int offset = Math.abs(length2 - length1);
        
        for (int i = 0; i < offset; i++) longer = longer.next;
        
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }
}