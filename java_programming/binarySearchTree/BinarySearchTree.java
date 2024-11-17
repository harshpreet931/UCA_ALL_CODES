package java_programming.binarySearchTree;

class A implements Comparable<A> {
    int x;

    A() {
        x = 0;
    }

    public int compareTo(A o) {
        if (this.x < o.x)
            return -1;
        else if (this.x > o.x)
            return 1;
        else
            return 0;
    }
}

public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
    class Node 
    {
        Key key;
        Value value;
        Node left, right;
        int count = 0;

        Node(Key key, Value value, int count)
        {
            this.key = key;
            this.value = value;
            left = right = null;
            this.count = count;
        }
    }

    private Node root;
    BinarySearchTree()
    {
        this.root = null;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node root, Key key)
    {
        if (root == null)
            return null;
        if (root.key.equals(key))
            return root.value;
        if (root.key.compareTo(key) > 0)
            return get(root.left, key);
        else
            return get(root.right, key);
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value)
    {
        if (root == null)
            return new Node(key, value, 1);

        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            root.left = put(root.left, key, value);
        else if (cmp > 0)
            root.right = put(root.right, key, value);
        else
            root.value = value;
        
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    public Key floor(Key key)
    {
        Node temp = floor(root, key);
        if(temp == null) return null;
        return temp.key;
    }

    private Node floor(Node root, Key key)
    {
        if(root == null) return null;
        
        if(root.key.equals(key)) return root;

        if(root.key.compareTo(key) > 0)
            return floor(root.left, key);
        
        Node temp = floor(root.right, key);
        if(temp != null) return temp;
        else return root;
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node root)
    {
        if(root == null) return 0;
        return root.count;
    }

    public int rank(Key key)
    {
        return rank(root, key);
    }

    private int rank(Node root, Key key)
    {
        if(root == null) return 0;

        if(root.key.equals(key)) return size(root.left);

        if(root.key.compareTo(key) > 0)
            return rank(root.left, key);
        else
            return size(root) + rank(root.right, key);
    }

    public Key ceil(Key key)
    {
        Node temp = ceil(root, key);
        if(temp == null) return null;
        return temp.key;
    }

    private Node ceil(Node root, Key key)
    {
        if(root == null) return null;

        if(root.key.equals(key)) return root;

        if(root.key.compareTo(key) < 0)
            return ceil(root.right, key);
        else
        {
            Node temp = ceil(root.left, key);
            if(temp != null) return temp;
            else return root;
        }
    }

    public void inorder_traversal()
    {
        inorder_traversal(root);
    }

    private void inorder_traversal(Node root)
    {
        if(root == null) return;
        inorder_traversal(root.left);
        System.out.println(root.key + " " + root.value);
        inorder_traversal(root.right);
    }

    public void postorder_traversal()
    {
        postorder_traversal(root);
    }

    private void postorder_traversal(Node root)
    {
        if(root == null) return;
        postorder_traversal(root.left);
        postorder_traversal(root.right);
        System.out.println(root.key + " " + root.value);
    }

    public void preorder_traversal()
    {
        preorder_traversal(root);
    }

    private void preorder_traversal(Node root)
    {
        if(root == null) return;
        System.out.println(root.key + " " + root.value);
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }

    private Key getMin(Node root)
    {
        if(root.left == null) return root.key;
        return getMin(root.left);
    }

    private Key getMax(Node root)
    {
        if(root.right == null) return root.key;
        return getMax(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<A, Integer> bst = new BinarySearchTree<A, Integer>();
        A a = new A();
        a.x = 10;
        bst.put(a, 10);

        A b = new A();
        b.x = 20;
        bst.put(b, 20);

        A c = new A();
        c.x = 5;
        bst.put(c, 5);

        System.out.println(bst.get(a));
        System.out.println(bst.get(b));
        System.out.println(bst.get(c));

        BinarySearchTree<Integer, Integer> bst1 = new BinarySearchTree<Integer, Integer>();
        bst1.put(10, 20);
        bst1.put(20, 40);
        bst1.put(5, 10);

        System.out.println(bst1.get(10));
        System.out.println(bst1.get(20));
        System.out.println(bst1.get(5));

        System.out.println(bst1.floor(7));

        System.out.println(bst1.size());

        System.out.println(bst1.rank(20));

        System.out.println(bst1.ceil(7));

        bst1.inorder_traversal();
        System.out.println();
        bst1.postorder_traversal();
        System.out.println();
        bst1.preorder_traversal();


    }
}