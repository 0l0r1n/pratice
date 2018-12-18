// From LeetCode's list of exercises
class MyLinkedList {
    
    ListNode head;
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null) 
            return -1;
       
        ListNode p = head;
        int i = 0;
        while (p != null && i < index) {
            p = p.next;
            i++;
        }
        if (i == index && p != null) 
            return p.val;
        
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
         if (head == null) {
             head = new ListNode();
             head.val = val;
         } else {
             ListNode temp = new ListNode();
             temp.val = val;
             temp.next = head;
             head = temp;
         }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) { 
            addAtHead(val);
        } else {
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            ListNode tail = new ListNode();
            tail.val = val;
            p.next = tail;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);   
        } else {
            ListNode p = head;
            int i = 0;
            if (p == null) return;
            while (p.next != null && i < index - 1) {
                p = p.next;
                i++;
            }
            if (i == index - 1) {
                ListNode n = new ListNode();
                n.val = val;
                n.next = p.next;
                p.next = n;
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) return;
        ListNode p = head;
        int i = 0;
        while (p != null && i < index - 1) {
            p = p.next;
            i++;
        }
        if (i == index - 1 && p != null && p.next != null) {
            p.next = p.next.next;
        }
    }
    
    private class ListNode {
        
        ListNode next;
        int val;
    }
}