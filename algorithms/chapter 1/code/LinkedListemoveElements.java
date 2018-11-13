/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if (head == null) return null;
        while (head != null && head.val == val) head = head.next;
        
        ListNode cursor = head;
        if(cursor == null) return null;
        
        while(cursor.next != null){
            if(cursor.next.val == val) cursor.next = cursor.next.next;
            else cursor = cursor.next;
            
        }
        return head;

    }
}