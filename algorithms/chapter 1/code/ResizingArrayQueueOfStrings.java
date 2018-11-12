import edu.princeton.cs.algs4.*;

public class ResizingArrayQueueOfStrings {

    String[] a;
    private int n, head, tail;

    public ResizingArrayQueueOfStrings() {
        this.head = 0;
        this.tail = 0;
        this.n = 0;
        a = new String[2];
    }

    public void enqueue(String s) {
        if (isFull()) resize(2*a.length);   
        a[tail++] = s;                        
        if (tail == a.length) tail = 0;          
        n++;
    }

    public String dequeue() {
        n--;
        head++;
        String item = a[head];
        if (head == a.length) head = 0;           
        return item;
    }

    public boolean isFull() {
        return a.length == n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public String peek() {
        return a[head];
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[(head + i) % a.length];
        }
        a = temp;
        head = 0;
        tail  = n;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}