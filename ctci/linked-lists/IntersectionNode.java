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

    ListNode findPointersV2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);
        if(result1.tail != result2 != tail) return null;

        ListNode shorter = result1.size < result2.size ? list1 : list2;
        ListNode longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result.size - result2.size));

        while (shoter != longer) {
            shoter = shoter.next;
            longer = longer.next;
        }
        return longer;
    }

    class Result {
        ListNode tail;
        int size;

        Result(ListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
        
    }

    Result getTailAndSize(ListNode list) {
        if (list == null) return null;
        int size = 1;
        ListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

}