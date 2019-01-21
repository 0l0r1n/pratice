public class BinarySearchIteratively {

    int search (arr[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}