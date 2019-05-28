/*
    The fast/slow runner approach is a great one for solving this kind of problem.
*/
public class LoopDetection {

    public static boolean solve(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}