class DeleteMiddle {

    void doDelete(Node head) {
        Node slow = head;
        Node fast = head;
        Node previousSlow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            previousSlow = slow;
            slow = slow.next;
        }
        previousSlow.next = slow.next;
    }
}