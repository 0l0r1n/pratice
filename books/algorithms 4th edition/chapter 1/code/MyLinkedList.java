// https://leetcode.com/problems/design-linked-list/
class MyLinkedList {
    
    public class Node<Integer> {
        Integer val;
        Node<Integer> prev;
        Node<Integer> next;
    }

    private Node<Integer> head;
    private Node<Integer> tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new Node<Integer>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node<Integer> cursor = head;
        for (int i = 0; i < index && cursor != null; i++) {
            cursor = cursor.next;
        }
        return cursor != null ? cursor.val : -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node<Integer> newHead = new Node<Integer>();
        newHead.val = val;
        newHead.next = head;
        head.prev = newHead; 
        head = newHead;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node<Integer> cursor = head.next;
        while (cursor != null) {
            cursor = cursor.next;
        }
        Node<Integer> tail = new Node<Integer>();
        tail.val = val;
        tail.prev = cursor;
        cursor.next = tail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node<Integer> cursor = head;
        int i;
        for (i = 0; i < index && cursor != null; i++) {
            cursor = cursor.next;
        }if (cursor != null) {
            Node<Integer> newNode = new Node<Integer>();
            newNode.prev = cursor.prev;
            newNode.next = cursor;
            cursor.prev = newNode;
        }
        if (cursor == null && i < index) addAtTail(val);
        if (cursor == null && i > index) return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node<Integer> cursor = getNode(index);
        if (cursor != null) {
            cursor.prev.next = cursor.next;
            if (cursor.next != null) cursor.next.prev = cursor.prev;
        }
    }

    private Node getNode(int index) {
        Node<Integer> cursor = head;
        for (int i = 0; i < index && cursor != null; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */