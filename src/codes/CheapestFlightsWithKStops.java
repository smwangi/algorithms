import java.util.*;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 *
 *
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 *
 * Constraints:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightsWithKStops {

    public static void main(String[] args) {

        CheapestFlightsWithKStops cheapestFlightsWithKStops = new CheapestFlightsWithKStops();
        //int n = 3,src = 0, dst=2,K=1;
        //int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};

        int n = 3,src = 0, dst=2,K=0;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(cheapestFlightsWithKStops.findCheapestPrice(n,flights,src,dst,K));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,Map<Integer,Integer>> prices = new HashMap<>();
        for (int[]f: flights){
            if(!prices.containsKey(f[0]))
                prices.put(f[0],new HashMap<>());
            prices.get(f[0]).put(f[1],f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0,src, K+1});

        while (!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];

            System.out.println("STOPS> "+stops);
            if(city == dst) return price;

            if(stops > 0){
                Map<Integer,Integer> adj = prices.getOrDefault(city,new HashMap<>());
                for (int a: adj.keySet()){
                    pq.add(new int[] {price + adj.get(a),a, stops - 1});
                }
            }
        }
        return -1;
    }
}
