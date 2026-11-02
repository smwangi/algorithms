import java.util.*;

public class BusRoutes {

    public static void main(String[] args) {
        int[][] routes = {{2, 5, 7}, {4, 6, 7}};
        int src = 2;
        int dest = 6;
        System.out.println(minimumBuses(routes, src, dest));
    }
    // Problem: https://leetcode.com/problems/bus-routes/
    // Solution: https://leetcode.com/problems/bus-routes/solution/
    /**
     * Create an adjacency list that maps each station to the buses that travel through it.
     * This is done by iterating through the routes and for each route, adding the route index to
     * the adjacency list for each station in the route.
     *
     * Next we use BFS to find a path from src to des using minimum number of buses since BFS always finds the shortest path in an unweighted graph.
     * The BFS is implemented using a queue that stores the bus index and the station index. Queue is initialized with the source station and a bus count of 0.
     *
     * Then we repeatedly dequeue the next station from the queue and if it is equal to the dest, we return the number of buses taken. Otherwise, we iterate through the
     * buses that travel through the current station and for each unvisited bus, we enqueue all the stations in that bus route along with bus count + 1. and mark
     * that bus as visited by adding it into the set of visited buses. If the queue becomes empty and no station is equal to the dest, we return -1.
     */
    static int minimumBuses(int[][] routes, int src, int dest)  {
        // Create adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i])   {
                adjList.putIfAbsent(station, new ArrayList<>());
                adjList.get(station).add(i);
            }
        }

        // Create a queue with initial source and bus count of 0
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {src, 0});

        // Create a set to store visited buses
        Set<Integer> visited = new HashSet<>();

        // Iterate till queue is empty
        while (!queue.isEmpty()) {
            // pop station and number of buses
            int[] current = queue.peek();
            int station = current[0];
            int busTaken = current[1];
            queue.poll();

            // If reached the destination, return number of buses taken
            if (station == dest) {
                return busTaken;
            }

            // and if it not already visited, enqueue all the stations in that bus route along with an incremented bus count and mark the bus visited
            if (adjList.containsKey(station))   {
                for (int bus : adjList.get(station)) {
                    if (!visited.contains(bus)) {
                        visited.add(bus);
                        for (int nextStation : routes[bus]) {
                            queue.add(new int[] {nextStation, busTaken + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
