
import java.util.*;

/**
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};////{{1,3},{-2,2}};
        int k = 2;
        printClosestPoints(points,k);
        KClosestPointToOrigin closestPointToOrigin = new KClosestPointToOrigin();
        closestPointToOrigin.kClosest(points,k);
    }

    static void printClosestPoints(int[][] point,int k){
       // PriorityQueue<>
        Map<List<Integer>,Integer> map = new HashMap<>();
        int[][]r = new int[k][];

        for (int j = 0;j < point.length-1; j++){
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i< point[j].length-1;i++){

                int sqDistance = ((point[j][i] * point[j][i]) + (point[j][i+1] * point[j][i+1]));
                res.add(point[j][i]);
                res.add(point[j][i+1]);
                map.put(res,sqDistance);
            }
        }

        PriorityQueue<Map.Entry<List<Integer>,Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        for(Map.Entry entry : map.entrySet()){
            queue.offer(entry);
            //System.out.println( entry.getKey()+" "+entry.getValue());
        }

        while (!queue.isEmpty()){
            Map.Entry<List<Integer>,Integer> temp = queue.poll();
            if(k-- > 0)
                r[k] = temp.getKey().stream().mapToInt(i->i).toArray();
                //System.out.println(temp.getKey());
            if(k == 0)break;
        }

        System.out.println(Arrays.toString(r));
    }

    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
