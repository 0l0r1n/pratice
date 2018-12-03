import edu.princeton.cs.algs4.*;

class UnionFind {

    private int[] id;
    private int count;

    public UF(int n) {
        count = n;
        for (int i = 0; i < n; i++) id[i] = i;
    }

    int count() {
        return count;
    }

    int connected(int p, int q) {
        return find(p) == find(q);
    }

    int find(int p) {
        return null;
    }

    void union(int p, int q) {

    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}