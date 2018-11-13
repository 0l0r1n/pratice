public class FindInLinkedList {

    public static boolean find(Node<String> node, String key) {
        if (node == null) return false;
        if (node.item == key) return true;
        return find(node, key);
    }

}