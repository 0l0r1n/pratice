public class MaxPriorityQueue<K extends Comparable<K>> {

    private K[] pq;
    private int n;

    MaxPriorityQueue(int max) {
        this.pq = (K[])new Comparable[max+2];
    }

    void insert(K k) {
        pq[++n] = k;
        swim(n);
    }

    K delMax() {
        K max = pq[1];
        swap(1, n--);
        pq[n+1] = null;
        return max;
    }

    boolean isEmpty() {
        return n == 0;
    }

    int size() {
        return this.n;
    }

    private void swim(int k) {
        while (k > 1&& less(k/2, k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        K t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}