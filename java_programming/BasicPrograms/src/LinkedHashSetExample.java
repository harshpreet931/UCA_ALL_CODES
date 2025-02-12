import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 4, 5, 6};
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i : arr) set.add(i);

        int[] arr2 = new int[set.size()];
        int idx = 0;

        for(int i : set) arr2[idx++] = i;

        System.out.println(set);
        System.out.println(Arrays.toString(arr2));
    }
}
