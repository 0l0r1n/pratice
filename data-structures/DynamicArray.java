class DynamicArray {
 
    int[] arr;
    int capacity;
    int size;
    
    DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    void add(int val) {
        if (size == capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
            arr = temp;
        }
        arr[size] = val;
        size++;
    }

}