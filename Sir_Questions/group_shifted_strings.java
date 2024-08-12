import java.util.*;

public class group_shifted_strings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String s : strings) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < s.length(); i++) {
                int space = s.charAt(i) - s.charAt(i-1);
                sb.append(space < 0 ? space + 26 : space);
                sb.append(",");
            }
            String key = sb.toString();
            if(!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(s);
        }

        for(List<String> list : mp.values()) {
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> res = groupStrings(strs);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("abc", "bcd", "xyz"));
        expected.add(Arrays.asList("acef"));
        expected.add(Arrays.asList("az", "ba"));
        expected.add(Arrays.asList("a", "z"));
        assert res.equals(expected) : "Test Case 1 Failed";

        String[] strs2 = {"a"};
        List<List<String>> res2 = groupStrings(strs2);
        List<List<String>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList("a"));
        assert res2.equals(expected2) : "Test Case 2 Failed";

        System.out.println("All test cases passed!!");
    }
}
