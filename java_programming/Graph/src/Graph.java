import java.util.Iterator;

public class Graph
{
    private int V;
    private int E;
    private Bag[] adj;

    public Graph(int V)
    {
        this.V = V;
        adj = new Bag[V];
        for(int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    public void addEdge(int v, int w)
    {
        adj[v].insert(w);
        adj[w].insert(v);
        E++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public int V() { return V; }
    public int E() { return E; }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for(int v = 0; v < V; v++)
        {
            sb.append(v + ": ");
            for(int w : adj(v))
                sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
