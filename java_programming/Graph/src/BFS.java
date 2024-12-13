import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public BFS(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph g, int s)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        marked[s] = true;

        while(!q.isEmpty())
        {
            int v = q.poll();
            for(int w : g.adj(v))
            {
                if(!marked[w])
                {
                    edgeTo[w] = v;
                    marked[w] = true;
                    q.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public void printPathTo(int v)
    {
        if(!hasPathTo(v))
        {
            System.out.println("No path to " + v);
            return;
        }

        LinkedList<Integer> path = new LinkedList<>();

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
