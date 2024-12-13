public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(4, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 6);
        g.addEdge(2, 6);
        g.addEdge(3, 7);

        System.out.println(g);
        System.out.println("Degree of vertex 0: " + GraphUtility.degree(g, 0));
        System.out.println("Degree of vertex 1: " + GraphUtility.degree(g, 1));
        System.out.println("Max degree: " + GraphUtility.maxDegree(g));

        DFS dfs = new DFS(g, 0);
        System.out.println("Path to 5: " + dfs.hasPathTo(7));
        System.out.print("Path to 5: ");
        dfs.printPathTo(7);
        System.out.println();

        BFS bfs = new BFS(g, 0);
        System.out.println("Path to 5: " + bfs.hasPathTo(7));
        System.out.print("Path to 5: ");
        bfs.printPathTo(7);
        System.out.println();
    }
}
