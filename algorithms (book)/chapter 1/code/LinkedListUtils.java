public class LinkedListUtils {

    public static void deleteLastNode(Node n) {
        if (n.next == null) n = null;
        if (n.next != null && n.next.next != null) deleteLastNode(n.next);
    }

    public static boolean find(Node node, String key) {
        if (node == null) return false;
        if (node.item == key) return true;
        return find(node, key);
    }

    public static void removeAfter(Node n) {
        if (n.next != null) n.next = n.next.next;
    }

    public static void insertAfter(Node n, Node next) {
        Node nextNext = n.next;
        n.next = next;
        next.next = nextNext;
    }

    public static remove(Node head, int val) {
        
        if (head == null) return null;
        while (head != null && head.item == val) head = head.next;
        
        Node cursor = head;
        if(cursor == null) return null;
        
        while(cursor.next != null){
            if(cursor.next.item == val) cursor.next = cursor.next.next;
            else cursor = cursor.next;
            
        }
        return head;
    }

    public static int max(Node<Integer> n) {
        if (n == null) return 0;
        else {
            int max = n.item;
            while (n != null) {
                if (n.item > max) max = n.item;
                n = n.next;
            }
            return max;
        }
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node reverse = null;
        while (current != null) {
            Node next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }
        return reverse;
    }

    public Node deleteDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }

    public static int recursiveMax(Node<Integer> n) {
        if (n == null) return 0;
        return recursiveMax(n.next, n.item);
    }

    private static int recursiveMax(Node<Integer> n, int currentMax) {
        if (n == null) return currentMax;
        if (n.item > currentMax) currentMax = n.item;
        return recursiveMax(n.next, currentMax);
    }
}