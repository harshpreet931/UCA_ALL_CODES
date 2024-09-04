import java.util.*;

public class tower_of_hanoi
{
    public static void main(String[] args)
    {
        toh(4, 1, 3, 2);
        return;
    }
    public static void toh(int n, int from, int to, int aux)
    {
        if(n == 1)
        {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        else
        {
            toh(n-1, from, aux, to);
            System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
            toh(n-1, aux, to, from);
        }
    }
}