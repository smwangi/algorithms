import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 *
 */
public class GraphPriceRange {
    public static void main(String[] args) {
        GraphPriceRange graphPriceRange = new GraphPriceRange();
        Graph graph = graphPriceRange.new Graph();

        Product p1 = graphPriceRange.new Product("Apple", 150);
        Product p2 = graphPriceRange.new Product("Banana", 75);
        Product p3 = graphPriceRange.new Product("Orange", 200);
        Product p4 = graphPriceRange.new Product("Grapes", 350);
        Product p5 = graphPriceRange.new Product("WaterMelon", 500);

        graph.addEdge(p1, p2, 50, 200);
        graph.addEdge(p2, p3, 100, 300);
        graph.addEdge(p3, p4, 200, 500);
        graph.addEdge(p4, p5, 300, 700);

        int low = 50;
        int high = 300;

        List<Product> result = graph.findItemsInRange(low, high);
        System.out.println("Products in the price range [" + low + ", " + high + "] are: ");
        result.forEach(product -> System.out.println(product.name + " : " + product.price));
    }
    class Product   {
        String name;
        int price;
        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    class Edge  {
        Product source;
        Product destination;
        int low, high;
        public Edge(Product source, Product destination, int low, int high) {
            this.source = source;
            this.destination = destination;
            this.low = low;
            this.high = high;
        }
    }

    class Graph {
        Map<Product, List<Edge>> adjList;
        public Graph() {
            adjList = new HashMap<>();
        }

        void addEdge(Product source, Product destination, int low, int high) {
            Edge edge = new Edge(source, destination, low, high);
            adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
            adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(edge);
        }

        List<Product> findItemsInRange(int low, int high) {
            Set<Product> visited = new HashSet<>();
            List<Product> result = new ArrayList<>();
            for (Product product : adjList.keySet()) {
                if (!visited.contains(product)) {
                    dfs(product, low, high, visited, result);
                }
            }
            return result;
        }

        private void dfs(Product product, int low, int high, Set<Product> visited, List<Product> result)    {
            visited.add(product);
            if (product.price >= low && product.price <= high) {
                result.add(product);
            }

            for (Edge edge : adjList.getOrDefault(product, Collections.emptyList())) {
                Product neighbour = edge.source == product ? edge.destination : edge.source;
                if (!visited.contains(neighbour) && edge.low >= low && edge.high <= high) {
                    dfs(neighbour, low, high, visited, result);
                }
            }
        }
    }
}
