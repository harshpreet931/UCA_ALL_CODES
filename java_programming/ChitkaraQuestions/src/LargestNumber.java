import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    private static String largestNumber(int[] arr)
    {
        String[] strArr = new String[arr.length];
        for(int i = 0; i < arr.length; i++) strArr[i] = Integer.toString(arr[i]);

        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        if(strArr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String str : strArr) sb.append(str);
        return sb.toString();
    }
}
