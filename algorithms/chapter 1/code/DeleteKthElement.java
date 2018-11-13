import edu.princeton.cs.algs4.*;

public class DeleteKthElement<Item> {

    private static void delete(Node n, int k, int callNo) {
        if (k -1 == callNo && n != null) n.next = null;
        else delete(n, k, callNo);
    }

    private static Node<String> initData() {
        Node<String> first = new Node<String>();
        Node<String> second = new Node<String>();
        Node<String> third = new Node<String>();
        Node<String> fourth = new Node<String>();
        first.item = "hi!";
        second.item = "how";
        third.item = "are";
        fourth.item = "you";
        first.next = second;
        second.next = third;
        third.next = fourth;
        return first;
    }

    public static void main(String[] args) {
        int k = StdIn.readInt();
        Node<String> first = initData();
        delete(first, k, 0);
    }

}