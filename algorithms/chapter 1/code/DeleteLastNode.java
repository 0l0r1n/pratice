public class DeleteLastNode {

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private static void doDelete(Node<Item> n) {
        if (n.next == null) n = null;
        else if (n.next != null && n.next.next != null) doDelete(n.next);
        else n.next = null;
    }
}