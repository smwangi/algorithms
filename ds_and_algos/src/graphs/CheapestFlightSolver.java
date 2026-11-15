package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * CheapestFlightSolver
 * Demonstrate state space expansion via Scalar State Tracking using a modified Dijkstra's algorithm
 * optimized for path-length constraints
 */
public class CheapestFlightSolver {
    
    // Immutable representation of a directed flight edge
    private record Flight(int targetCity, int price) {}

    /**
     * Internal data structure representing a structural path step in the Priority Queue
     * 
    */
   private record PathState(int currentCost, int city, int stopsRemaining) implements Comparable<PathState> {
        @Override 
        public int compareTo(PathState other) {
            // Min-Heap sorting strategy based explicitly on total path cost
            return Integer.compare(this.currentCost, other.currentCost);
        }
   }

   /**
    * Computes the cheapest route cost from a source city to destination city while
    * staying strictly under a specific maximum stop threshold
    * @param cities
    * @param flights
    * @param src
    * @param dest
    * @param stops
    * @return
    */
   public int findCheapestFlight(int cities, int[][] flights, int src, int dest, int stops) {
     // Step 1: Input Validation Guards
     if (cities <= 0 || flights == null || src < 0 || dest < 0 || src >= cities || dest >= cities || stops < 0) {
        return -1;
     }

     // Step 2: Build an efficient adjacency list
     List<List<Flight>> adjacencyList = new ArrayList<>(cities);

     for (int i = 0; i < cities; i++) {
        adjacencyList.add(new ArrayList<>());
     }

     for (int[] flight : flights) {
        int from = flight[0];
        int to = flight[1];
        int price = flight[2];

        adjacencyList.get(from).add(new Flight(to, price));
     }

     // Step 3: Initialize State Resource Trackers
     /**
      * bestStopsRemaining[city] records the most flights left over by any earlier POP of this city.
      * Its job is pruning, so the search doesn't explode. When you pop a city, the question is:
      * "Have I already been here in a way that is better in every respect?"
      * Earlier pops were cheaper (the heap pops in cost order), so if one also had at least as
      * many flights left, this path is pointless and gets dropped.
      *
      * Why pop time and not push time? Pushes do NOT happen in cost order, only pops do.
      * Pruning at push time can throw away a cheaper path just because a pricier one was pushed first
      * (see the "regression" case in CheapestFlightSolverTest).
      */
     int[] bestStopsRemaining = new int[cities];

     /**
      * new int[cities] fills the array with 0s. A 0 would mean "I was here with 0 flights left",
      * which would wrongly beat a real visit that also has 0 flights left.
      * -1 means "never popped; any real state (0 or more flights left) beats this."
      * It's the standard way to set up a "best so far" value:
      * Searching for a minimum? Start at +∞ (MAX_VALUE), so the first real value always wins.
      * Searching for a maximum (like here)? Start below any possible value (MIN_VALUE, or -1 when values are >= 0).
      * You'll see the same pattern in Dijkstra (dist[] starts at ∞), in DP tables for "minimum coins", and in any running minimum.
      */
     Arrays.fill(bestStopsRemaining, -1);

     // Standard Min-Heap structure driven by path cost comparisons
     PriorityQueue<PathState> minHeap = new PriorityQueue<>();

     // Prime the Queue with our base starting state
     // Notice we pass (k+1) as stopsRemaining: k stops allow k+1 flights. Taking a flight decrements the counter
     minHeap.offer(new PathState(0, src, stops + 1));

     // Step 4 Constrained Dijkstra Traversal Loop
     while (!minHeap.isEmpty()) {
         PathState current = minHeap.poll();

         // Goal Invariant: states are popped in cost order, and every state in the heap
         // is within the stop limit, so the first time dest is popped its cost is the answer
         if (current.city == dest) {
            return current.currentCost;
         }

         // Pruning step: only expand this pop if it has strictly more flights left
         // than every earlier (cheaper) pop of the same city
         if (current.stopsRemaining <= bestStopsRemaining[current.city]) {
            continue;
         }
         bestStopsRemaining[current.city] = current.stopsRemaining;

         // Resource Guard: If no flight hop remains, we cannot traverse further from this state
         if (current.stopsRemaining == 0) {
            continue;
         }

         // Explore flights originating from the current city
         for (Flight flight : adjacencyList.get(current.city)) {
            minHeap.offer(new PathState(current.currentCost + flight.price, flight.targetCity, current.stopsRemaining - 1));
         }
     }

     return -1;
   }

}
