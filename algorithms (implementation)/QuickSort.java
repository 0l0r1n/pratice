import java.util.Random;

public class QuickSort {

    public static void sort(int[] arr) { 
        sort(arr, 0, arr.length - 1);
    } 

    public static void sortRandom(int[] arr) {
        sortRandom(arr, lo, hi);
    }

    private static void sortRandom(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = new Random(arr.length).nextInt();
        int index = partition(arr, lo, hi, pivot);
        sortRandom(arr, lo, index -1);
        sortRandom(arr, index, hi);
    }

    private static int partition(int[] arr, int lo, int hi, int pivot) {
        while (lo <= hi) {
            while (arr[lo] < arr[pivot]) lo++;
            while (arr[hi] > arr[pivot]) hi--;
        }
        if (lo < hi) {
            swap(arr, lo, hi);
            lo++;
            hi--; 
        }
        return left;
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            p = partition(arr, lo, hi);
            sort(arr, lo, p);
            sort(arr, p + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < arr[pivot]);
            do {
                j--;
            } while (arr[j] > arr[pivot]);
            if (i >= j) return j;
            swap(arr, i, j);
        }  
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}