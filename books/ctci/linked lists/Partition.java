import java.util.ArrayList;

public class Partition {

    // runs on time and space O(n)
    public static Node solve(Node head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;
        ArrayList<Node> leftPartition = new ArrayList<>();
        ArrayList<Node> rightPartition = new ArrayList<>();
        Node pointer = head;

        while (p != null) {
            if (p.val < x) leftPartition.add(p);
            else rightPartition.add(p);
        }

        if (leftPartition.size() > 0) head = leftPartition.get(0);
        else head = rightPartition.get(0);

        for (int i = 0 ; i < leftPartition.size() - 1; i++) leftPartition.get(i).next = leftPartition.get(i + 1);
        leftPartition.get(leftPartition.size() - 1).next = rightPartition.get(0);
        for (int i = 0 ; i < rightPartition.size() - 1; i++) rightPartition.get(i).next = rightPartition.get(i + 1);
        
        return head;
    }

    public class Node {

        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}