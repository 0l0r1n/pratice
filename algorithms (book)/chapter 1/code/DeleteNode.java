/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNode {
    public void doDelete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}