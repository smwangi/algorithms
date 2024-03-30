import java.util.*;

public class AdjacencyListExample {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.bfs(0);
        graph.dfs(0);
    }
    //BFS
    static class Graph {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Adding elements to adjacency list (undirected)
        void addEdge(int source, int destination)   {
            adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
        }

        void bfs(int startNode) {
            boolean[] visited = new boolean[adjList.size()];
            Queue<Integer> queue = new LinkedList<>();
            visited[startNode] = true;
            queue.add(startNode);

            System.out.println("BFS Traversal:");
            while (!queue.isEmpty())    {
                int currentNode = queue.poll();
                System.out.print(currentNode + " ");
                for (int neighbour : adjList.getOrDefault(currentNode, Collections.emptyList()))    {
                    if (!visited[neighbour])    {
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
            }
            System.out.println();
        }

        void dfsRecursive(int v, boolean[] visited)  {
            visited[v] = true;
            System.out.print(v + " ");

            for (int neighbour : adjList.getOrDefault(v, Collections.emptyList()))    {
                if (!visited[neighbour])    {
                    dfsRecursive(neighbour, visited);
                }
            }
        }

        void dfs(int startNode) {
            boolean[] visited = new boolean[adjList.size()];
            System.out.println("DFS Traversal:");
            dfsRecursive(startNode, visited);
            System.out.println();
        }
    }
}
