import java.util.Iterator;

public class Deque<T> implements Iterable<T> {

    private int size;
    private Node first;
    private Node last;

    public Deque() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void pushLeft(T t) {
        Node newFirst = new Node(t);
        if (first == null && last == null) {
            first = newFirst;
            last = newFirst;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    public void pushRight(T t) {
        Node newLast = new Node(t);
        if (first == null && last == null) {
            first = newLast;
            last = newLast;
        } else {
            newLast.prev = last;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public T popLeft() {
        if (!isEmpty()) {
            T t = first.t;
            first = first.next;
            size--;
            return t;
        } else {
            return null;
        }
    }

    public T popRight() {
        if (!isEmpty()) {
            T t = last.t;
            last = last.prev;
            size--;
            return t;
        } else {
            return null;
        }
    }

    public Iterator<T> iterator() {
        return new Dequeterator();
    }

    private class Dequeterator implements Iterator<T> {

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

    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>();
        d.pushLeft(2);
        d.pushLeft(2);
        d.pushRight(3);
        d.pushLeft(4);
        d.pushLeft(10);
        d.pushRight(11);
        d.popRight();
        d.popRight();
        d.pushRight(3);
        d.popLeft();
        Iterator<Integer> iterator = d.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }

    private class Node {
        T t;
        Node next;
        Node prev;

        public Node(T t) {
            this.t = t;
        }
    }
}