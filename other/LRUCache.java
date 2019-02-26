import java.util.HashMap;

class LRUCache {
    
    private HashMap<Integer, Node> cacheMap;
    private DoublyLinkedList cacheList;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
		cacheMap = new HashMap<>(cacheSize);		
		cacheList = new DoublyLinkedList(cacheSize);
    }

    public Node getData(int dataKey) {
        Node data = null;
        if (cacheMap.containsKey(dataKey)) {
            data = cacheMap.get(dataKey);
            cacheList.moveToHead(data);
        } else {
            if (cacheList.getCacheSize() == cacheList.currentSize()) {
                int dataToRemove = cacheList.removeLast();
                cacheMap.remove(dataToRemove);
            }
            data = cacheList.addFirst(dataKey);
            cacheMap.put(dataKey, data);
        }
        return data;
    }

    class DoublyLinkedList {
        private final int cacheSize;
        private int currentSize;
        private Node head;
        private Node tail;

        public DoublyLinkedList(int size) {
            cacheSize = size;
            currentSize = 0;
            head = null;
            tail = null;
        }

        public Node addFirst(int data) {
            Node n = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                currentSize = 1;
            }
            currentSize++;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return n;
        }

        public int removeLast() {
            int data = tail.data;
            tail = tail.prev;
            tail.next = null;
            currentSize--;
            return data;
        }

        public void moveToHead(Node n) {
            if (n == null || head == null || n == head) return;
            if (n == tail) {
                tail = tail.prev;
                tail.next = null;
            }

            Node next = n.next;
            Node prev = n.prev;

            prev.next = next;
            if (next != null)
                next.prev = prev;
            
            n.prev = null;
            n.next = head;
            head.prev = n;

            head = n;
        }

        public int getCacheSize() {
            return cacheSize;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }
    }

    class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
        }
    }
}