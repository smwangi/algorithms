import java.util.*;

public class GraphValidPath {
    private boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Edge Cases
        if (edges.length == 0 || source == destination || n == 1) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //return bfs(map, source, destination);
        dfs(map, visited, source, destination);
        return found;
    }

    private boolean bfs(Map<Integer, List<Integer>> map, Integer source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[map.size()];
        q.add(source);

        while (!q.isEmpty()) {
            int popped = q.poll();

            if (visited[popped] == true)
                continue;

            visited[popped] = true;
            List<Integer> neighbors = map.get(popped);

            for (int neigh  :   neighbors) {
                if (neigh == destination) return true;

                q.add(neigh);
            }
        }
        return false;
    }

    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int source, int dest) {
        if (visited[source] || found) {
            return;
        }
        visited[source] = true;

        for (int neig : map.get(source)) {
            if (neig == dest) {
                found = true;
                break;
            }
            if (!visited[neig]) {
                dfs(map, visited, neig, dest); // check again
            }
        }
    }
}
