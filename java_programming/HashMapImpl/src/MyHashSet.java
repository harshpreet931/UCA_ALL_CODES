import java.util.*;

public class MyHashSet<E> implements Iterable{
    // set interface, unique data having o(1) or o(k) time complexity where
    // k is the number of elements in the bucket in SET CRUD operations.
    // hashset, linkedhashset, treeset.
    // hashset is implemented using hashmap.
    // linkedhashset -> hashmap + doubly linked list.
    // treeset -> treemap -> red black tree.

    private LinkedList<E>[] buckets;
    private int bucketCount;
    private int size = 0;
    private float loadFactor;

    public MyHashSet(int bucketCount, float loadFactor)
    {
        buckets = new LinkedList[8];
        this.loadFactor = loadFactor;
        this.bucketCount = bucketCount;
    }

    public MyHashSet()
    {
        this(8, 0.75f);
    }

    public void insert(E element)
    {
        int hashCode = getBucketNumber(element);
        buckets[hashCode].add(element);
        size++;

        if(buckets[hashCode].size() > loadFactor * size)
        {
            bucketCount *= 2;
            rehash();
        }
    }

    private void rehash()
    {
        Iterator<E> it = this.iterator();
        LinkedList<E>[] temp = new LinkedList[bucketCount];
        while(it.hasNext())
        {
            E element = it.next();
            int bucketNumber = getBucketNumber(element);
            temp[bucketNumber].add(element);
        }
        this.buckets = temp;
    }

    private int getBucketNumber(E e)
    {
        return e.hashCode() % bucketCount;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            Iterator<E> it = null;
            int idx = 0;
            @Override
            public boolean hasNext() {
                if(it == null)
                {
                    if(size == 0) return false;
                    it = buckets[idx].iterator();
                    return true;
                }
                if(it.hasNext()) return true;
                idx++;
                if(idx > bucketCount) return false;
                it = buckets[idx].iterator();
                return true;
            }

            @Override
            public E next() {
                return it.next();
            }
        };
    }
}
