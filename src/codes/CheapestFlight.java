package codes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 * If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 *
 * explanation
 *
 * Algorithm:
 * Initially push the src into the heap
 * for every step:
 *
 * check if the current top element in heap is dst. If so return its costFromSrc;
 * Push every adjacent edge into the heap if the distance is less than k;
 * If it is larger than k, no more neighbors get pushed into the heap;
 * If until the end, we cannot find dst, return -1;
 */
public class CheapestFlight {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int k = 1,src=0,dst=2;
        CheapestFlight cheapestFlight = new CheapestFlight();
        System.out.println(cheapestFlight.findCheapestPrice(n,edges,src,dst,k));
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int routes = -1;
        if(n <= 0 || flights ==  null || flights.length == 0 || K < 0)
            return routes;
        List<List<Pair>> graph = new ArrayList<>();
        this.buildGraph(graph,n, flights);

        Queue<City> pQueue = new PriorityQueue<>((City c1,City c2) -> c1.costFromSrc - c2.costFromSrc);
        pQueue.offer(new City(src,0,0));

        int totalCost = 0;
        while (!pQueue.isEmpty()){
            City top  = pQueue.poll();
            if(top.city == dst){
                return top.costFromSrc;
            }
            if(top.distFromSrc > K){
                continue;
            }
            List<Pair> neighbors = graph.get(top.city);
            for(Pair neighbor: neighbors){
                pQueue.offer(new City(neighbor.city,top.distFromSrc+1,top.costFromSrc + neighbor.cost));
            }
        }


        return routes;
    }

    private void buildGraph(List<List<Pair>> graph, int n, int[][] flights){
        for(int i = 0;i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight:flights) {
            graph.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
    }

    class Pair{
        int city,cost;
        Pair(int city,int cost){
            this.city = city;
            this.cost = cost;
        }
    }

    class City{
        int city,distFromSrc,costFromSrc;
        City(int city,int distFromSrc, int costFromSrc){
            this.city = city;
            this.distFromSrc = distFromSrc;
            this.costFromSrc = costFromSrc;
        }
    }
}
