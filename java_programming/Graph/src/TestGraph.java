public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(4, 5);

        System.out.println(g);
        System.out.println("Degree of vertex 0: " + GraphUtility.degree(g, 0));
        System.out.println("Degree of vertex 1: " + GraphUtility.degree(g, 1));
        System.out.println("Max degree: " + GraphUtility.maxDegree(g));

    }
}
