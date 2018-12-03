import edu.princeton.cs.algs4.*;

class QuickFind {

    private int[] id;
    private int count;

    public QuickFind(int n) {
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
        return id[p];
    }

    void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (PID == qID) return;
        for (int i = 0; i < id.length; i++) if (id[i == pID]) id[i] = qID;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFind uf = new QuickFind(n);
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