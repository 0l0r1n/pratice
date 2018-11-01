import edu.princeton.cs.algs4.*;

public class Euclid {

    public static int gcd(int p, int q) {
        StdOut.println("p: " + p);
        StdOut.println("q: " + q);
        if (q == 0) return p;
        int r = p % q;
        StdOut.println("r: " + r);
        return gcd(q, r);
    }
    public static void main(String[] args) {
        In in = new In();
        int p = in.readInt();
        int q = in.readInt();
        Euclid.gcd(p, q);
    }

}