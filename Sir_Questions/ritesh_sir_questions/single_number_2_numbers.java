public class single_number_2_numbers {
    public static int[] singleNum(int[] arr) 
    {
        int xor = 0;
        for(int i : arr) xor ^= i;

        int diffBit = xor & -xor;
        System.out.println(diffBit);

        int num1 = 0, num2 = 0;
        for(int i : arr)
        {
            if((i & diffBit) == 0) num1 ^= i;
            else num2 ^= i;
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 4, 1, 3};
        int[] result = singleNum(arr);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
