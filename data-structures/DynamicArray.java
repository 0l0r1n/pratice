class DynamicArray {
 
    int[] arr;
    int capacity;
    int size;
    int count;
    int first;
    int last;

    DynamicArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    void add(int val) {
        if (count == arr.length) {
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
            arr = temp;
            size = arr.length;
        }
        arr[size] = temp;
        size++;
    }

}