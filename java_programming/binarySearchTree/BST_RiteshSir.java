import java.util.*;

public class BST_RiteshSir<K extends Comparable<K>, V> 
{
    private Node root;

    private class Node 
    {
        private K key;
        private V value;
        private Node left, right;
        
        public Node(K key, V value) 
        {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    public void insert(K key, V value)
    {
        root = insert(root, key, value);
    }

    private Node insert(Node root, K key, V value)
    {
        if(root == null)
            return new Node(key, value);

        int cmp = key.compareTo(root.key);

        if(cmp > 0)
            root.right = insert(root.right, key, value);
        else if(cmp < 0)
            root.left = insert(root.left, key, value);
        else
            root.value = value; // update value

        return root;
    }

    public K getMin() 
    {
        Node n = getMin(root);
        return n == null ? null : n.key;
    }

    private Node getMin(Node root)
    {
        if(root == null)
            return null;
        if(root.left == null)
            return root;
        return getMin(root.left);
    }

    public void deleteMin()
    {
        if(root == null) return;

        root = deleteMin(root);
    }

    private Node deleteMin(Node root)
    {
        if(root.left == null) 
            return root.right;
        
        root.left = deleteMin(root.left);
        return root;
    }

    public void delete(K key)
    {
        root = delete(root, key);
    }

    private Node delete(Node root, K key)
    {
        if(root == null) return null;
        int cmp = key.compareTo(root.key);
        if(cmp > 0)
            root.right = delete(root.right, key);
        else if(cmp < 0)
            root.left = delete(root.left, key);
        else
        {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            Node sucesssor = root.right;
            while(sucesssor.left != null)
                sucesssor = sucesssor.left;

            root.key = sucesssor.key;
            root.value = sucesssor.value;

            root.right = delete(root.right, sucesssor.key);
        }
        return root;
    }

    public K firstCommonAncestor(K p, K q)
    {
        if(search(p) == null || search(q) == null) return null;
        return firstCommonAncestor(root, p, q, null);
    }

    private K firstCommonAncestor(Node root, K p, K q, Node parent)
    {
        int comp1 = p.compareTo(root.key);
        int comp2 = q.compareTo(root.key);
        
        if(comp1 < 0 && comp2 > 0 || comp1 > 0 && comp2 < 0) return root.key;
        
        if(comp1 > 0 && comp2 > 0) return firstCommonAncestor(root.right, p, q, root);
        if(comp1 < 0 && comp2 < 0)firstCommonAncestor(root.left, p, q, root);

        // of any of them is equal to root, then we need to return parent of root
        return parent == null ? null : parent.key;
    }

    public Node search(K key)
    {
        return search(root, key);
    }

    private Node search(Node root, K key)
    {
        if(root == null) return null;
        int cmp = key.compareTo(root.key);
        if(cmp == 0) return root;
        if(cmp > 0) return search(root.right, key);
        return search(root.left, key);
    }

    // Task: Convert BST to a sorted circular doubly linked list

    public static void main(String[] args) {
        BST_RiteshSir<Integer, String> bst = new BST_RiteshSir<>();
        bst.insert(5, "null");
        bst.insert(3, null);
        bst.insert(4, null);
        bst.insert(2, null);
        bst.insert(6, null);
        bst.insert(7, null);
        bst.insert(8, null);

        System.out.println(bst.getMin());
        bst.deleteMin();
        System.out.println(bst.getMin());
        bst.deleteMin();
        System.out.println(bst.getMin());
        bst.deleteMin();    
        System.out.println(bst.getMin());

    }
}
