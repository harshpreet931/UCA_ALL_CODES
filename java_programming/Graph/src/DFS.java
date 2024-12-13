import java.util.Stack;

public class DFS
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public DFS(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph g, int s)
    {
        marked[s] = true;
        for(int w : g.adj(s))
        {
            if(!marked[w])
            {
                edgeTo[w] = s;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public void printPathTo(int v)
    {
        Stack<Integer> path = new Stack<Integer>();

        for(int x = v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }

        path.push(s);

        while(!path.isEmpty())
        {
            System.out.print(path.pop() + " -> ");
        }
    }
}
