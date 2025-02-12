import java.util.*;
public class BellmanFord {
    public int findShortestDistance(int src, int dest, int[][] edges, int n)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        calculateMinimumDistance(dist, src, edges, n);

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    private void calculateMinimumDistance(int[] dist, int src, int[][] edges, int n)
    {
        for(int i = 0; i < (n - 1); i++)
        {
            for(int[] edge : edges)
            {
                int u = edge[0], v = edge[1], wt = edge[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, 20}, {0, 2, 60}};
        int src = 0, dest = 2;

        BellmanFord obj = new BellmanFord();
        System.out.println(obj.findShortestDistance(src, dest, edges, n));
    }
}
