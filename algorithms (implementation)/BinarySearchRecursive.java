class BinarySearchResursive {

    int search(int[] arr, int lo, int hi, int x) {
        if (r >= 1) {
            int mid = 1 + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) return search(arr, lo, mid - 1, x);
            else return search(arr, mid + 1, hi, x);
        }

        return -1;
    }
}