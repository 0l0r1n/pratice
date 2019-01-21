
import java.util.Arrays;
import java.util.ArrayList;


/**
 *  The {@code BinarySearch} class provides a static method for binary
 *  searching for an integer in a sorted array of integers.
 *  <p>
 *  The <em>indexOf</em> operations takes logarithmic time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
import edu.princeton.cs.algs4.*;

public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int[] removeDuplicates(int[] a) {
        ArrayList<Integer> intlist = new ArrayList<Integer>();

        intlist.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                intlist.add(a[i]);
            }
        }

        int size = intlist.size();
        int[] a1 = new int[size];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = intlist.get(i);
        }

        return a1;
    }

    private static int rank(int[]a, int key) {
        BinarySearch.removeDuplicates(a);
        return indexOf(a, key);
    }

    private static int count(int[] a, int key) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key && i + 1 != a.length) {
                counter++;
                i++;
                while (a[i] == key && i + 1 != a.length) {
                    counter++;
                    i++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);
        
        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println("count: " + BinarySearch.count(whitelist, key));
            StdOut.println("rank: " + BinarySearch.rank(whitelist, key));
            if (BinarySearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }
}