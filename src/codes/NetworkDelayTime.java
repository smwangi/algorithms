import java.util.*;

/**
 * Given a network of n nodes, labeled from 1 to n, also given times, a list of travel times as directed edges times[i] = (Ui,Vi,Wi),
 * where Ui is the source node, Vi is the target node, and Wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k, return the minimum time it takes for all the nodes n to receive the signal else return -1
 * if impossible for all nodes to receive the signal.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list
        Map<Integer, List<int[]>> adjacency = new HashMap<>();
        //Store source as key, and destination and time as values
        for (int[] time : times) {
            //print the adjacency dictionary
            printAdjacency(adjacency);
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            adjacency.computeIfAbsent(
                    source,
                    key -> new ArrayList<>()).add(new int[] {destination, travelTime});
        }
        // Print the adjacency dictionary
        printAdjacency(adjacency);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        System.out.println("\t pq element: " + Arrays.toString(pq.poll()));
        System.out.println("\t visited set:" + visited);
        return -1;
    }

    private  static void printAdjacency(Map<Integer, List<int[]>> adjacency) {
        System.out.print("\t Adjacency dictionary: {");
        boolean isFirst = true;
        for (Map.Entry<Integer, List<int[]>> entry : adjacency.entrySet()) {
            if (!isFirst) {
                System.out.print(", ");
            }
            int source = entry.getKey();
            List<int[]> destinations = entry.getValue();
            System.out.print(source + ": [");
            for (int i = 0; i < destinations.size(); i++) {
                int[] destination = destinations.get(i);
                System.out.print("(" + destination[0]+", " + destination[1]+ "0");
                if (i < destinations.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            isFirst = false;
        }
        System.out.println("}");
    }
}
