import java.util.LinkedList;

public class RouteBetweenNodes {

    public static boolean hasRouteBFS(Node start, Node end) {
        if (start == end) return true;
        LinkedList<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current == end) return true;
            visited.add(current);
            for (Node n : current.children()) {
                if (!visited.contains(n)) q.add(n);
            }
        }

        return false;
    }

    public static boolean hasRouteDFS(Node start, Node end) { 
        HashSet<Node> visited = new HashSet<>();
        return hasRouteDFS(start, end, visited);
    }

    private static boolean hasRouteDFS(Node start, Node end, HashSet<Node> visited) {
        if (start == end) return true;
        if (visited.contains(start)) return false;
        visited.add(start);
        for (Node n : start.children()) {
            if (hasRouteDFS(n, end, visited)) return true;
        }
        return false;
    }   
}