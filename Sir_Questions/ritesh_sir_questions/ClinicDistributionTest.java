import java.util.*;
public class ClinicDistributionTest {
    public static void main(String[] args) {
        System.out.println(minimizeMaxLoad(new int[]{100, 50, 200}, 4));
        assert minimizeMaxLoad(new int[]{100, 50, 200}, 4) == 100 : "Sir test case Failed";
        assert minimizeMaxLoad(new int[]{100}, 1) == 100 : "Test Case 1 Failed";
        assert minimizeMaxLoad(new int[]{200, 200}, 4) == 100 : "Test Case 2 Failed";
        assert minimizeMaxLoad(new int[]{100, 50, 200}, 4) == 100 : "Test Case 3 Failed";
        assert minimizeMaxLoad(new int[]{500, 300, 200, 100}, 3) == 500 : "Test Case 4 Failed";
        assert minimizeMaxLoad(new int[]{10, 20, 30, 40, 50}, 10) == 20 : "Test Case 5 Failed";
        assert minimizeMaxLoad(new int[]{60, 80, 70, 90}, 4) == 90 : "Test Case 6 Failed";
        assert minimizeMaxLoad(new int[]{100, 100, 100, 100}, 4) == 100 : "Test Case 7 Failed";

        System.out.println("All test cases passed!");
    }

    public static int minimizeMaxLoad(int[] population, int m) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for(int i : population) {
            pq.add(new double[]{i, 1});
            m--;
        }

        while(m-- > 0) {
            double[] max = pq.poll();
            max[1]++;
            max[0] = max[0] / max[1];
            pq.add(max);
        }
        
        return (int) pq.poll()[0];
    }
}
