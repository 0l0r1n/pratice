public class Josephus {

    private static int solvePosition(int n, int m) {
        Node first = new Node(1);
        Node prev = first; 
        for(int i = 2; i <= n; i++) { 
            prev.next = new Node(i); 
            prev = prev.next; 
        }
        prev.next = first; 
        Node ptr1 = first, ptr2 = first; 
          
        while(ptr1.next != ptr1) { 
            int count = 1; 
            while(count != m) { 
                ptr2 = ptr1; 
                ptr1 = ptr1.next; 
                count++; 
            } 
            ptr2.next = ptr1.next; 
            ptr1 = ptr2.next; 
        } 
        return ptr1.value;
    }

    public static void main(String[] args) {
        int n = 14, m = 2; 
        System.out.println(solvePosition(n, m));
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}