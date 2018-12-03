class Exercise_1_5_1 {

    private int[] id;
    private int count;
    private int accesses;

    public Exercise_1_5_1(int n) {
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
        while (p != id[p]) {
            p = id[p];
            accesses += 2;
        }
        return p;
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        accesses++;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        Exercise_1_5_1 uf = new Exercise_1_5_1(n);
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