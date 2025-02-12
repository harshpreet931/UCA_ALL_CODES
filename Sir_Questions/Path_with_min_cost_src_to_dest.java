import java.util.*;

class Path_with_min_cost_src_to_dest {

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 100}, {1, 3, 500}, {3, 4, 100}, {0, 2, 100}, {2, 3, 100}, {2, 4, 10000}};
        int n = 5, src = 0, dest = 4;
        int[] res = minPath(edges, n, src, dest);
        System.out.println("Min distance: " + res[0] + ", Min time: " + res[1]);
    }

    static class Pair {
        int dist, time;
        Pair(int dist, int time) {
            this.dist = dist;
            this.time = time;
        }
    }

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static public int[] minPath(int[][] edges, int n, int src, int dest) {
        Pair res = minPathHelper(edges, n, src, dest);
        if (res.dist == Integer.MAX_VALUE) return new int[]{-1};
        return new int[]{res.dist, res.time};
    }

    static private Pair minPathHelper(int[][] edges, int n, int src, int dest) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Edge(u, v, w));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dist = new int[n];
        int[] time = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(time, Integer.MAX_VALUE);

        dist[src] = 0;
        time[src] = 0;
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], v = curr[1], t = curr[2];

            for (Edge e : graph.get(v)) {
                int newDist = d + e.w, newTime = t + 1;

                if (newTime < time[e.v] || (newTime == time[e.v] && newDist < dist[e.v])) {
                    dist[e.v] = newDist;
                    time[e.v] = newTime;
                    pq.offer(new int[]{newDist, e.v, newTime});
                }
            }
        }

        return new Pair(dist[dest], time[dest]);
    }
}