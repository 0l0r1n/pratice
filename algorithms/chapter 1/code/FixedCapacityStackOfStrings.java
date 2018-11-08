import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a;    
    private int N;       

    
    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];   
        N = 0;
    }

    public boolean isEmpty() {  
        return N == 0;                    
    }

    public boolean isFull() {
        return a.length == N;
    }

    public void push(Item item) {
        a[N++] = item;                    
    }

    public Item pop() {  
        return a[--N];                    
    }

    public Iterator<Item> iterator()  { 
        return new ReverseArrayIterator(); 
    }


    public class ReverseArrayIterator implements Iterator<Item> {
        private int i = N-1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item); 
            else if (stack.isEmpty())  StdOut.println("BAD INPUT"); 
            else                       StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    } 
} 
