import java.util.Arrays;

class BinaryHeap<T extends Comparable<T>> {
    
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] data;
    protected int size;

    BinaryHeap() {
        data = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    void add(T value) {
        if (size == data.length - 1) this.resize();
        size++;
        data[size] = value;
        swim();
    }

    void swim() {
        int index = this.size;
        while (hasParent(index)
                && (parent(index).compareTo(data[index]) > 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }

    void sink() {
        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChild = leftIndex(index);
            if (hasRightChild(index)
                && data[leftIndex(index)].compareTo(data[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (data[index].compareTo(data[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }
            index = smallerChild;
        }        
    }

    T peek() {
        if (this.isEmpty()) throw new IllegalStateException();
        return data[1];
    }

    T remove() {
        T value = this.peek();
        data[1] = data[size];
        data[size] = null;
        size--;
        sink();
        return value;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    protected boolean hasParent(int i) {
        return i > 1;
    }

    protected int leftIndex(int i) {
        return i * 2;
    }
    
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    protected T parent(int i) {
        return data[parentIndex(i)];
    }
    
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    
    protected T[] resize() {
        return Arrays.copyOf(data, data.length * 2);
    }
    
    
    protected void swap(int index1, int index2) {
        T tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;        
    }
}