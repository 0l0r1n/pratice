public class RemoveDupesNoNuffer { 

    void removeDupes(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) runner.next = runner.next.next;
                runner = runner.next;
            }
            current = current.next;
        }
    }
}