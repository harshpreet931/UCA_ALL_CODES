package java_programming.interface2;

import java.util.*;

public class listInterface {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new Vector<>();
        List<Integer> list4 = new Stack<>();

        Set<Integer> set = new HashSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        
        System.out.println(list);
        System.out.println(list2);
    }    
}
