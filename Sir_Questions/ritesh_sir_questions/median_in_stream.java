import java.util.*;

public class median_in_stream {
    public static void main(String[] args) {
        median_in_stream obj = new median_in_stream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public median_in_stream() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        balance();
    }

    private void balance() {
        if(left.size() < right.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
