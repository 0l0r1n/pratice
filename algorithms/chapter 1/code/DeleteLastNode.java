public class DeleteLastNode<Item> {

    private static void doDelete(Node n) {
        if (n.next == null) n = null;
        if (n.next != null && n.next.next != null) doDelete(n.next);
    }

}