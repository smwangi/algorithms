import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFSImplementation {

    public static void main(String[] args) {
        Graph graph = new DFSImplementation().new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,4);

        //Print the DFS Traversal Sequence
        System.out.println("Depth First Traversal for given graph"+
                "(with 0 as starting vertex)");
        graph.DFS(0);

        System.out.println();
        GraphUnidirectedByAdjacencyList unidirectedByAdjacencyList = new DFSImplementation().new GraphUnidirectedByAdjacencyList(3);
        unidirectedByAdjacencyList.addEdge(0,1);
        unidirectedByAdjacencyList.addEdge(1,2);
        unidirectedByAdjacencyList.addEdge(2,0);
        unidirectedByAdjacencyList.printAdjacencyList();
        
        GraphDfs graphDfs = new DFSImplementation(). new GraphDfs(4);
        graphDfs.addEdge(0,1);
        graphDfs.addEdge(0,2);
        graphDfs.addEdge(1,2);
        graphDfs.addEdge(2,3);
        System.out.println("Following is the Depth First Traversal.");
        graphDfs.DFS(0);
    }
    class Graph{
        private int vertices; //No of vertices
        //Adjacency list  declaration
        private LinkedList<Integer>adj_list[];

        // graph Constructor: to initialize adjacency lists as per no of vertices
        Graph(int v){
            vertices = v;
            adj_list = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj_list[i] = new LinkedList<>();
            }
        }
        //Add an edge to the graph
        void addEdge(int v, int w){
            adj_list[v].add(w);//add w to v's list
        }
        // helper function for DFS technique
        void DFS_helper(int v, boolean visited[]){
            //mark current node as visited and print it
            visited[v] = true;
            System.out.print(v+" ");
            // Recur for all the vertices adjacent to this
            //process all adjacent vertices
            Iterator<Integer> i = adj_list[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFS_helper(n,visited);
                }
            }
        }
        // The function to do DFS traversal. It uses recursive
        void DFS(int v){
            // Mark all the vertices as not visited (default as false in Java)
            //initially none of the vertices are visited
            boolean visited[] = new boolean[vertices];
            // call recursive DFS_helper function for DFS traversal
            DFS_helper(v,visited);
        }
    }

    class GraphUnidirectedByAdjacencyList{
        private int V;
        private List<List<Integer>> adjacencyList;

        public GraphUnidirectedByAdjacencyList(int V){
            this.V = V;
            adjacencyList = new ArrayList<>(V);
            for (int i = 0; i < V; ++i){
                adjacencyList.add(new ArrayList<>());
            }
        }

        public Integer getV(){
            return this.V;
        }

        public List<List<Integer>> getAdjacencyList() {
            return adjacencyList;
        }

        public void addEdge(int src,int dest){
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        }

        public void printAdjacencyList(){
            for (int i = 0; i < V; i++){
                System.out.printf("Adjacency list of vertex %d is %s %s", i,
                        adjacencyList.get(i), System.lineSeparator());
            }
        }
    }
    class GraphDfs {
        private LinkedList<Integer> adjList[];
        private boolean visited[];
        
        // Graph Creation
        GraphDfs(int vertices) {
            adjList = new LinkedList[vertices];
            visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        // Add Edges
        void addEdge(int src, int dest) {
            adjList[src].add(dest);
        }
        
        // DFS Algorithm
        void DFS(int vertex) {
            visited[vertex] = true;
            System.out.print(vertex+" ");
            
            Iterator<Integer> iterator = adjList[vertex].listIterator();
            while (iterator.hasNext()) {
                int adj = iterator.next();
                if (!visited[adj])
                    DFS(adj);
            }
            System.out.println();
        }
    }
    class Node {
        String name;
        List<Node> children = new ArrayList<>();
        
        public Node(String name) {
            this.name = name;
        }
        
        // O(v+e) time | O(v) space -> v = nodes, e = edges
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }
        
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
