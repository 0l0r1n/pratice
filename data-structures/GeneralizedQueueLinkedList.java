public class GeneralizedQueueLinkedList<T> {

    Node first;
    Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T value) {
        Node n = new Node(value);
        if (first == null) {
            first = n;
            last = first;
        } else {
            last.next = n;
            n.prev = last;
            last = n;
        }
    }

    public T delete(int k) {
        int counter = 0;
        for (Node n = first; n != null; n = n.next) {
            if (k == counter) {
                T value = n.value;
                Node temp = n.prev;
                n.prev = n.next;
                if (n.next != null) n.next.prev = temp;
                return value;
            }
            counter++;
        }
        return null;
    }
    
    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }
}