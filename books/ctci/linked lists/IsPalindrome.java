import java.util.Stack;

public class IsPalindrome {

    public static boolean solveWithStack(ListNode head) {
        if (head == null) return true;
        Stack<ListNode> s = new Stack<>();
        ListNode pointer;
        for (pointer = head; pointer != null; pointer = pointer.next) s.push(pointer);
        pointer = head;
        while (pointer != null) { 
            if (pointer.val != s.pop().val) return false;
            pointer = pointer.next;
        }
        return true;
    }

    public static boolean solveByReversing(ListNode head) {
        if (head == null) return true;
        ListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed); 

    }

    private static ListNode reverseAndClone(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode n = new ListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) return false;
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}