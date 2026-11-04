import java.util.*;

class Solution {

public int findMaxPathScore(int[][] edges, boolean[] online, long k){
        int maxCost = 0;

        for (int[] e : edges) {
            maxCost = Math.max(maxCost, e[2]);
        }

        int left = 0, right = maxCost;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(edges, online, k, mid)) {
                answer = mid;
                left = mid + 1;     // try for larger minimum edge cost
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int[][] edges, boolean[] online,
                               long k, int minEdgeCost) {

        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph using only valid edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];

            if (cost < minEdgeCost)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            if (v != 0 && v != n - 1 && !online[v])
                continue;

            graph[u].add(new int[]{v, cost});
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // Topological DP
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] next : graph[u]) {
                int v = next[0];
                int cost = next[1];

                if (dist[u] != Long.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + cost);
                }

                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return dist[n - 1] <= k;
    }
}