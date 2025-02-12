import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human <K extends Comparable<K>>{
    K marks;
    Human(K key) {this.marks = key;}

    public int compareTo(Human<K> person1) {
        return marks.compareTo(person1.marks);
    }

    public static void main(String[] args) {
        List<Human<Integer>> arr = new ArrayList<>();

        arr.add(new Human<>(10));
        arr.add(new Human<>(20));
        arr.add(new Human<>(30));
        arr.add(new Human<>(40));

        Collections.sort(arr, (a, b) -> (b.marks - a.marks));
    }
}
