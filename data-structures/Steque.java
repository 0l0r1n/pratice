import java.util.Iterator;

class Steque<T> implements Iterable<T> {

    Node first;
    Node last;

    public void push(T t) {
        Node n = new Node(t);
        if (first == null && last == null) {
            first = n;
            last = n;
        } else {
            n.next = first;
            first.prev = n;
            first = n;
        }
    }

    public T pop() {
        Node oldFirst = first;
        first = first.next; 
        return oldFirst.t;
    } 

    public void enqueue(T t) {
        Node n = new Node(t);
        last.next = n;
        n.prev = last;
        last = n;
    }

    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<T> {

        private Node current = first; 

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.t;
            current = current.next;
            return item;
        }
    }

    private class Node {
        T t;
        Node next;
        Node prev;

        public Node(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Steque<Integer> s = new Steque<>();
        s.push(5);
        s.push(10);
        s.push(2);
        s.push(40);
        s.pop();
        s.pop();
        s.push(2);
        s.push(321);
        s.enqueue(3);
        s.enqueue(10);
        s.pop();
        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}