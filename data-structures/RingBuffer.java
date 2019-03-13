public class RingBuffer<T> {

    T[] buffer;
    int count;
    int first;
    int last;

    public RingBuffer(int capacity) {
        buffer = (T[]) new Object[capacity];
        count = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == buffer.length;
    }

    public void push(T item) {
        if (count == buffer.length) {
            throw new RuntimeException("Ring buffer overflown");
        }
        buffer[first] = item;
        first = (first + 1) % buffer.length;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty ring buffer");
        }
        T item = buffer[last];
        count--;
        last = (last + 1) % buffer.length;
        return item;
    }
}