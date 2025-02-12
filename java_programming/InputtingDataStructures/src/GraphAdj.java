import java.util.*;
public class GraphAdj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v); // edge from -> u to v
            adj.get(v).add(u); // edge from -> v to u
        }
    }
}
