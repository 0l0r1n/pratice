
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.*;

public class StackLinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;

    public StackLinkedList() {
        this.N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        return item;
    }

    public void push(Item item) {
        Node<Item> n = new Node<Item>();
        n.item = item;
        n.next = first;
        first = n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public static void main(String[] args) {
        StackLinkedList<String> stack = new StackLinkedList<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
    
}