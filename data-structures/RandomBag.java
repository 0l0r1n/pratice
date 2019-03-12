import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class RandomBag<T> implements Iterable<T> {

    private int size;
    private Node first;
    private Node last;

    public RandomBag() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T t) {
        Node n = new Node(t);
        if (first == null) {
            first = n;
            last = n;
        } else {
            last.next = n;
            last = n;
        }
        size++;
    }

    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {

        private T[] items;
        private int cursor;

        RandomBagIterator() {
            items =(T[]) new Object[size];
            int i = 0;
            cursor = 0;
            for (Node n = first; n != null; n = n.next) {
                items[i] = n.t;
                i++;
            } 
            Collections.shuffle(Arrays.asList(items));;
        }

        public boolean hasNext() {
            return cursor == items.length;
        }

        public T next() {
            T item = items[cursor];
            cursor++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> rb = new RandomBag<>();
        rb.add(10);
        rb.add(24);
        rb.add(3);
        rb.add(11);
        rb.add(32);
        rb.add(321);
        rb.add(768);
        rb.add(9);
        rb.add(87);
        rb.add(1);
        rb.add(2983);
        Iterator<Integer> iterator = rb.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }

    private class Node {
        Node next;
        T t;

        Node(T t) {
            this.t = t;
        }
    }
}