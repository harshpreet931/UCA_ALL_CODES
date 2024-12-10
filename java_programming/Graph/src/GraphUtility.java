public class GraphUtility
{
    public static int degree(Graph g, int v)
    {
        int degree = 0;
        for(int w : g.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph g)
    {
        int max = 0;
        for(int v = 0; v < g.V(); v++)  max = Math.max(max, degree(g, v));
        return max;
    }

    public boolean hasDirectPath(Graph g, int v, int w)
    {
        for(int x : g.adj(v)) if(x == w) return true;
        return false;
    }


}
