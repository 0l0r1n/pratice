class BinaryTree {

    Node root;

    void add(int value) {
        root = addRecursively(root, value);
    }

    boolean containsNode(int value) {
        return containsNodeRecursively(root, value);
    }

    Node search(int value) {
        return search(root, value);
    }

    private Node addRecursively(Node current, int value) {
        if (current == null) return new Node(value);
        else if (value < current.value) current.left = addRecursively(current.left, value);
        else if (value > current.value) current.right = addRecursively(current.right, value);
        return current;
    }

    private boolean containsNodeRecursively(Node current, int value) {
        if (current == null) return false;
        if (value == current.value) return true;
        return value < current.value ? containsNodeRecursively(current.left, value) : containsNodeRecursively(current.right, value);
    }

    private Node deleteRecursively(Node current, int value) {
        if (current == null) return null;
        if (current.value == value) {
            if (current.left == null && current.right == null) return null;
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;
        } if (current.value > value) {
            current.left = deleteRecursively(current.left, value);
            return current;
        }
        current.right = deleteRecursively(current.right, value);
        return current;
    }

    private Node search(Node current, int value)  { 
        if (current ==null || current.value==value) return current; 
        if (current.value > value) return search(current.left, value);  
        return search(current.right, value); 
    } 

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}