import edu.princeton.cs.algs4.*;

class WeightedUnionFind {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedUnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    int count() {
        return count;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        UnionFind uf = new UnionFind(n);
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