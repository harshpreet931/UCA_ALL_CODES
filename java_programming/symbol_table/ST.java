package java_programming.symbol_table;

public interface ST {
    public void put(int key, int value);
    public int get(int key);
    public void delete(int key);
    public boolean contains(int key);
    public boolean isEmpty();
    public int size();
    public Iterable<Integer> keys();
}
