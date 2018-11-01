import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class RecursiveBinarySearch {

    public static int indexOf(int[] a, int key) {
        return indexOf(a, key, 0, a.length - 1, 0);
    }

    public static int indexOf(int[]a, int key, int lo, int hi, int stackCall) {
        StdOut.println("stackCall " + stackCall + " - hi: " + hi + " - low: " + lo);
        if (lo > hi) return - 1;
        int mid = lo + (hi - lo)/2;
        stackCall++;
        if (key < a[mid]) return indexOf(a, key, lo, mid - 1, stackCall);
        if (key > a[mid]) return indexOf(a, key, mid + 1, hi, stackCall);
        else return mid;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (RecursiveBinarySearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }
}