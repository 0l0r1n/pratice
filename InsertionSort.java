class InsertionSort {

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j > 0 && numbers[j] > key) {
                numbers[j+1] = numbers[j];  
                j--;
            }
            numbers[j+1] = key; 
        }
    }   
    
}