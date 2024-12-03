public class Trie<Value>
{
    private static final int R = 126;
    private Node root;
    private int n;

    private static class Node
    {
        Object val;
        Node[] next = new Node[R];
    }

    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if(x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d)
    {
        if(x == null) return null;
        if(key.length() == d) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value value)
    {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d)
    {
        if(x == null)
        {
            x = new Node();
            n++;
        }
        if(key.length() == d)
        {
            x.val = value;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

    public int numOfNodes()
    {
        return n;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<Integer>();

        trie.put("hello", 1);
        trie.put("hell", 2);
        trie.put("world", 3);

        assert trie.get("hello") == 1;
        assert trie.get("hell") == 2;
        assert trie.get("world") == 3;
        assert trie.get("he") == null;
        System.out.println("All tests passed!");
        System.out.println("Number of nodes: " + trie.numOfNodes());
        System.out.println("Is empty: " + trie.isEmpty());
    }
}
