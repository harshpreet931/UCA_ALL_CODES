public class Timepass {
    public static void main(String[] args) {
        Timepass t = new Timepass();
        System.out.println(t.sum(1, 2, 3, 4, 5));
    }

    private int sum(int... a)
    {
        int sum = 0;
        for(int i : a)
        {
            sum += i;
        }
        return sum;
    }

}
