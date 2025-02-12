public class BCDGREY {
    public static void main(String[] args) {
        int number = 12;
        String bcd = Integer.toBinaryString(number);
        System.out.println("BCD1: " + bcd);
        String bcd2 = toBCD(number);
        System.out.println("BCD2: " + bcd2);
        String gray = bcdTOGray("01001");
        System.out.println("Gray: " + gray);
        System.out.println("Gray to BCD: " + greyConverter(4));
    }

    private static String toBCD(int number)
    {
        StringBuilder bcd = new StringBuilder();
        for(char digit : String.valueOf(number).toCharArray())
        {
            int digitValue = digit - '0';
            String toAppend = Integer.toBinaryString(digitValue);
            while(toAppend.length() < 4) toAppend = "0" + toAppend;
            bcd.append(toAppend);
        }
        return bcd.toString();
    }

    private static String bcdTOGray(String bcd)
    {
        StringBuilder grayCode = new StringBuilder();
        for(int i = 0; i < bcd.length(); i++)
        {
            char bit = bcd.charAt(i);
            char prevBit = i > 0 ? bcd.charAt(i - 1) : '0';
            grayCode.append(bit == prevBit ? '0' : '1');
        }
        return grayCode.toString();
    }

    private static int greyConverter(int n)
    {
        return n ^ (n >> 1);
    }
}
