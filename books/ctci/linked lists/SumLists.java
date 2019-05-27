import java.util.LinkedList;
import java.util.Queue;

public class SumLists {

    public ListNode solve(ListNode l1, ListNode l2) {
        Queue<ListNode> q1 = new LinkedList();
        Queue<ListNode> q2 =  new LinkedList();
        for (ListNode p = l1; p != null; p = p.next) q1.add(p);
        for (ListNode p = l2; p != null; p = p.next) q2.add(p);

        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            int val1 = q1.poll().val;
            int val2 = q2.poll().val;
            int total = val1 + val2 + carry;
            pointer.next = new ListNode(total % 10);
            pointer = pointer.next;
            carry = total / 10;
        }
        
        while (!q1.isEmpty()) {
            int total = q1.poll().val + carry;
            pointer.next = new ListNode(total % 10);
            pointer = pointer.next;
            carry = total / 10;
        }

        while (!q2.isEmpty()) {
            int total = q2.poll().val + carry;
            pointer.next = new ListNode(total % 10);
            pointer = pointer.next;
            carry = total / 10;
        }
        if (carry == 1) pointer.next = new ListNode(1);
        
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}