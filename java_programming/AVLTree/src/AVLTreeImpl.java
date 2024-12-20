public class AVLTreeImpl<K extends Comparable<K>, V>
{
    class Node
    {
        K key; V value;
        Node left, right;
        int height;

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(K key, V value)
    {
        root = insert(root, key, value);
    }

    private Node insert(Node root, K key, V value)
    {
        if (root == null)
            return new Node(key, value);

        if (key.compareTo(root.key) < 0)
            root.left = insert(root.left, key, value);
        else if (key.compareTo(root.key) > 0)
            root.right = insert(root.right, key, value);
        else
            root.value = value;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && key.compareTo(root.left.key) < 0)
            return rightRotate(root);

        if (balance < -1 && key.compareTo(root.right.key) > 0)
            return leftRotate(root);

        if (balance > 1 && key.compareTo(root.left.key) > 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && key.compareTo(root.right.key) < 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private int height(Node node)
    {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node)
    {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public void get(K key)
    {
        Node node = get(root, key);
        System.out.println(node == null ? "Key not found" : node.value);
    }

    private Node get(Node root, K key)
    {
        if (root == null)
            return null;

        if (key.compareTo(root.key) < 0)
            return get(root.left, key);
        else if (key.compareTo(root.key) > 0)
            return get(root.right, key);
        else
            return root;
    }

    public void traverse()
    {
        traverse(root);
    }

    private void traverse(Node root)
    {
        if (root == null)
            return;

        traverse(root.left);
        System.out.println(root.key + " " + root.value);
        traverse(root.right);
    }
}
