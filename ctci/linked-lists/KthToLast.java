public class KthToLast {

    public Node findRecursive(Node n, int k) {
        Index i = new Index();
        return findRecursive(n, k, index);
    }

    public Node findRecursive(Node head, int k, index i) {
        if (head == null) return null;
        Node n = findRecursive(n, k, i);
        i.value++;
        if (i.value == k) return head;
        return node;
    }

    public Node findIteraterively(Node n, index k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) { 
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    class Index {
        public int value = 0;    
    }
}