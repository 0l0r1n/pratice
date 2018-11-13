public class FindInLinkedList {

    private static boolean find(Node<String> node, String key) {
        if (node == null) return false;
        if (node.item == key) return true;
        return find(node, key);
    }
    public static void main(String[] args) {
        find(null, null);
    }
}