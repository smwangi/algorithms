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
    }
    class Graph{
        private int vertices; //No of vertices
        //Adjacency list  declaration
        private LinkedList<Integer>adj_list[];

        // graph Constructor: to initialize adjacency lists as per no of vertices
        Graph(int v){
            vertices = v;
            adj_list = new LinkedList[v];
            for (int i = 0; i<v; ++i){
                adj_list[i] = new LinkedList<>();
            }
        }
        //Add an edge to the graph
        void addEdge(int v, int w){
            adj_list[v].add(w);//add w to v's list
        }
        // helper function for DFS technique
        void DFS_helper(int v, boolean visited[]){
            //current node is visited
            visited[v] = true;
            System.out.print(v+" ");
            //process all adjacent vertices
            Iterator<Integer> i = adj_list[v].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    DFS_helper(n,visited);
                }
            }
        }

        void DFS(int v){
            //initially none of the vertices are visited
            boolean visited[] = new boolean[vertices];
            // call recursive DFS_helper function for DFS technique
            DFS_helper(v,visited);
        }
    }

    class GraphUnidirectedByAdjacencyList{
        private int V;
        private List<List<Integer>> adjacencyList;

        public GraphUnidirectedByAdjacencyList(int V){
            this.V = V;
            adjacencyList = new ArrayList<>(V);
            for (int i = 0; i< V; ++i){
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
}
