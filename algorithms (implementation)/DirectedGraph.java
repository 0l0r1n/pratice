import java.io.*; 
import java.util.*; 

public class DirectedGraph {
    private int V;
    private LinkedList<Integer> adj[];
    
    public DirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void topologicalSort() {
        Stack stack = new Stack();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) visited[i] = false;
        for (int i = 0; i < V; i++) if (visited[i] == false) topologicalSortUtil(i, visited, stack);
        while(!stack.isEmpty()) System.out.println(stack.pop() + " ");
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        int i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) topologicalSortUtil(i, visited, stack);
        }
        stack.push(v);
    }

}