public class RedBlackTree<K extends Comparable<K>, V> {
    class Node {
        K key; V value;
        Node left, right;
        boolean isRed;

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.isRed = true;
        }
    }

    private Node root;

    public void insert(K key, V value)
    {
        root = insert(root, key, value);
        root.isRed = false;
    }

    private Node insert(Node root, K key, V value)
    {
        if (root == null)
            return new Node(key, value);

        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            root.left = insert(root.left, key, value);
        else if (cmp > 0)
            root.right = insert(root.right, key, value);
        else
            root.value = value;

        if (isRed(root.right) && !isRed(root.left))
            root = rotateLeft(root);
        if (isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);
        if (isRed(root.left) && isRed(root.right))
            flipColors(root);

        return root;
    }

    private boolean isRed(Node node)
    {
        return node != null && node.isRed;
    }

    private void flipColors(Node root)
    {
        root.isRed = true;
        root.left.isRed = !root.left.isRed;
        root.right.isRed = !root.right.isRed;
    }

    private Node rotateLeft(Node root)
    {
        Node x = root.right;
        root.right = x.left;
        x.left = root;
        x.isRed = root.isRed;
        root.isRed = true;
        return x;
    }

    private Node rotateRight(Node root)
    {
        Node x = root.left;
        root.left = x.right;
        x.right = root;
        x.isRed = root.isRed;
        root.isRed = true;
        return x;
    }

    public V get(K key)
    {
        return get(root, key);
    }

    private V get(Node root, K key)
    {
        if (root == null)
            return null;

        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            return get(root.left, key);
        else if (cmp > 0)
            return get(root.right, key);
        else
            return root.value;
    }

    public void inorder()
    {
        inorder(root);
    }

    private void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.println(root.key + " " + root.value);
        inorder(root.right);
    }

    public void preoder()
    {
        preoder(root);
    }

    private void preoder(Node root)
    {
        if (root == null)
            return;

        System.out.println(root.key + " " + root.value);
        preoder(root.left);
        preoder(root.right);
    }

    public static void main(String[] args) {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<>();

        rbt.insert(1, "One");
        rbt.insert(2, "Two");
        rbt.insert(3, "Three");
        rbt.insert(4, "Four");
        rbt.insert(5, "Five");

        rbt.inorder();
        System.out.println("--------------------------");
        rbt.preoder();
    }
}
