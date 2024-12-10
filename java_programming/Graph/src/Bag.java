import java.util.Iterator;

public class Bag<T> implements Iterable<T>
{
    private Node head;

    public void insert(T data)
    {
        head = insert(head, data);
    }

    private Node insert(Node node, T data)
    {
        if(node == null) return new Node(data);
        node.next = insert(node.next, data);
        return node;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
}
