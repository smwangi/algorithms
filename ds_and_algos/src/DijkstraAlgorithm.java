import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 9;
        ArrayList<ArrayList<AdjListNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(7, 8));
        graph.get(1).add(new AdjListNode(2, 8));
        graph.get(1).add(new AdjListNode(7, 11));
        graph.get(1).add(new AdjListNode(0, 7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));

        int[] distance = dijkstra(V, graph, 0);
        System.out.println(Arrays.toString(distance));

        for (int i = 0; i < V; i++) {
            System.out.println("Distance of vertex " + i + " from the source is " + distance[i]);
        }

        int nodeCount = 6;
        List<List<NodeDist>> graph2 = new ArrayList<>(nodeCount);
        for (int i = 0; i < nodeCount; i++) {
            graph2.add(new ArrayList<>());
        }
        // Node 0
        Collections.addAll(graph2.get(0), new NodeDist(1, 5), new NodeDist(2, 1), new NodeDist(3, 4));
        // Node 1
        Collections.addAll(graph2.get(1), new NodeDist(0, 5), new NodeDist(2, 3), new NodeDist(4, 8));
        // Node 2
        Collections.addAll(graph2.get(2), new NodeDist(0, 1), new NodeDist(1, 3), new NodeDist(3, 2), new NodeDist(4, 1));
        // Node 3
        Collections.addAll(graph2.get(3), new NodeDist(0, 4), new NodeDist(2, 2), new NodeDist(4, 2), new NodeDist(5, 1));
        // Node 4
        Collections.addAll(graph2.get(4), new NodeDist(1, 8), new NodeDist(2, 1), new NodeDist(3, 2), new NodeDist(5, 3));
        // Node 5
        Collections.addAll(graph2.get(5), new NodeDist(3, 1), new NodeDist(4, 3));

        int sourceNode = 0;
        shortestPath(sourceNode, nodeCount, graph2);
    }
    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w) {
            vertex = v;
            weight = w;
        }

        int getVertex() {
            return vertex;
        }

        int getWeight() {
            return weight;
        }
    }

    // Function to find the shortest distance of all the vertices from source vertex S
    public static int[] dijkstra(int V, ArrayList<ArrayList<DijkstraAlgorithm.AdjListNode>> graph, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(Comparator.comparingInt(AdjListNode::getWeight));
        pq.add(new AdjListNode(src, 0));

        while (!pq.isEmpty()) {
            AdjListNode currentNode = pq.poll();

            for (AdjListNode neighbor : graph.get(currentNode.getVertex())) {
                if (distance[currentNode.getVertex()] + neighbor.getWeight() < distance[neighbor.getVertex()]) {
                    distance[neighbor.getVertex()] = distance[currentNode.getVertex()] + neighbor.getWeight();
                    pq.add(new AdjListNode(neighbor.getVertex(), distance[neighbor.getVertex()]));
                }
            }
        }
        // If you want to calculate distance from source to a particular target, you can return distance[target]
        return distance;
    }

    // SHORTEST PATH DIJKSTRA ALGORITHM
    static class NodeDist {
        int node; //Adjacent Node
        long dist; //Distance to adj node

        NodeDist (int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static void shortestPath(int source_node, int node_count, List<List<NodeDist>> graph) {
        // Assume dist from source to all other nodes is infinity
        // in the beginning, init the distance list to a max value
        Long INF = Long.MAX_VALUE;
        List<Long> dist = new ArrayList<>(Collections.nCopies(node_count, INF));

        // Distance from source vertex to itself is 0
        dist.set(source_node, 0L); //(Node, Dist)
        // Comparator lambda that enables the priority queue to store the nodes based on the distance in the ascending order
        Comparator<NodeDist> comparator = Comparator.comparingLong(a -> a.dist);
        // Priority Queue to store the nodes based on the distance in the ascending order
        PriorityQueue<NodeDist> pq = new PriorityQueue<>(comparator);
        // Add the source node to the priority queue
        pq.add(new NodeDist(source_node, 0));

        while (!pq.isEmpty())   {
            NodeDist current = pq.poll();
            int currentNode = current.node;

            for (NodeDist nodeDist : graph.get(currentNode)) {
                int neighbor = nodeDist.node;
                long newDist = dist.get(currentNode) + nodeDist.dist;
                if (newDist < dist.get(neighbor)) {
                    dist.set(neighbor, newDist);
                    pq.add(new NodeDist(neighbor, newDist));
                }
            }
        }

        for (int i = 0; i < node_count; i++) {
            //System.out.println("Distance of vertex " + i + " from the source is " + dist.get(i));
            System.out.printf("Source Node(%d) -> Destination Node(%d) : %d%n", source_node, i, dist.get(i));
        }
    }
}
