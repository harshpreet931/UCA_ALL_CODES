
// why K extends Comparable<K> and not K implements Comparable<K>?
// this is because when Java Generics were introduced, they were designed to be compatible with the existing code.
// So, if you have a class that already implements an interface, you can't change it to extend another class.
// So, to make it compatible with the existing code, they used extends instead of implements.
// And K extends Comparable<K> means that K is a subclass of Comparable<K> or K is a class that implements Comparable<K>.

// first one is a class and all the other are interfaces
public class BST<K extends Comparable<K>, V> {
    /*
     * Qualitites of BST:
     *  Unique keys
     *  Key value DS
     *  Efficient search/insert/delete/update log(n)
     *  Used in Databases
     *  Used in Symbol Tables
     *  Used in Dictionaries
     *  Used in Maps
    */

    private class Node 
    {
        public K key;
        public V value;
        public Node left;
        public Node right;
    }


}
