import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
    
        g.BFS(2);
    }
    
    //Create Graph
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }
    
    // Add edge to graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    // Print BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited (By Default)
        // Set as false
        boolean visited[] = new boolean[V];
        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // Mark the current not as visited and enqueue it
        visited[s] = true;
        q.add(s);
        while (q.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = q.poll();
            System.out.print(s+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        System.out.println();
    }
}
