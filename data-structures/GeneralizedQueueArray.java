import java.util.Arrays;

public class GeneralizedQueueArray<T> {

    T[] items;
    int first;
    int last;
    static int defaultCapacity = 2;

    public GeneralizedQueueArray() {
        this.last = 0;
        this.first = -1;
        items = (T[]) new Object[defaultCapacity];
    }

    public boolean isEmpty() {
        return this.last == 0;
    }

    public void insert(T item) {
        if (first == -1) first = 0;
        if (items.length == last) resize(items.length * 2);
        items[last++] = item;
    }

    public T delete(int k) {
        T value = this.items[k];
        this.items[k] = null;
        if (last > 0 && last == items.length/4) resize(items.length/2);
        return value;
    }

    private void resize(int newCapacity) {
        T[] temp =(T[]) new Object[newCapacity];
        for (int i = 0; i < items.length; i++) temp[i] = items[i];
        items = temp;
    }

    public static void main(String[] args) {
        GeneralizedQueueArray<Integer> gq = new GeneralizedQueueArray<>();
        gq.insert(3);
        gq.insert(4);
        gq.insert(5); 
        gq.insert(1);
        gq.insert(2);
        gq.insert(3);
        gq.delete(2);
        gq.delete(0);
        gq.delete(0);
        gq.delete(1);
        gq.delete(2);
        gq.delete(3);
        System.out.println(Arrays.toString(gq.items));
    }
}