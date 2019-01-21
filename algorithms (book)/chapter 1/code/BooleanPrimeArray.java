import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class BooleanPrimeArray {

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    private static boolean relativelyPrime(int p, int q) {
        return gcd(p,q) == 1;
    }
    
    public static boolean[][] buildArray(int size) {
        boolean[][] a = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = relativelyPrime(i, j);
            }
        }
        return a;
    }
    public static void main(String[] args) {
        StdOut.print("Please provide array size: ");
        int size = StdIn.readInt();
        System.out.println(Arrays.toString(buildArray(size)));
    }

}