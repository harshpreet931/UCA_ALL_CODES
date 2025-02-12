import java.util.*;

public class PracticeInputs {
    public static void main(String[] args) {
    //        Scanner sc = new Scanner(System.in);
    //        String[] input = sc.nextLine().trim().split(" ");
    //        int[] arr = new int[input.length];
    //
    //        int idx = 0;
    //        for(String s : input)
    //            arr[idx++] = Integer.parseInt(s);
    //
    //        System.out.println(Arrays.toString(arr));

    //        Scanner sc = new Scanner(System.in);
    //        List<int[]> edges = new ArrayList<>();
    //
    //        while(sc.hasNextLine())
    //        {
    //            String line = sc.nextLine().trim();
    //            if(line.isEmpty()) break;
    //
    //            String[] input = line.split(" ");
    //            int[] edge = new int[2];
    //            edge[0] = Integer.parseInt(input[0]);
    //            edge[1] = Integer.parseInt(input[1]);
    //            edges.add(edge);
    //        }
    //
    //        for(int[] edge : edges)
    //            System.out.println(Arrays.toString(edge));

        // compressed to normal
        String s = "a10g4v12x";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                int num = 0;
                i++;
                int count = 1;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                for (int j = 0; j < Math.max(count, num); j++)
                    sb.append(c);
            }
            else {
                sb.append(c);
                i++;
            }
        }
        System.out.println(sb.toString());
        }
    }
