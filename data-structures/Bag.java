import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

    private Node<T> first;
    private int n;

    private static class Node<T> {
        private T t;
        private Node<T> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T t) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.t = t;
        first.next = oldFirst;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;
        
        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T t = current.t;
            current = current.next;
            return t;
        }
    }
}