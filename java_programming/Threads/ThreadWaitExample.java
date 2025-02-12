//public class ThreadWaitExample {
//    class SharedResource {
//        int val;
//        boolean hasValue = false;
//
//        synchronized void produce(int val) {}
//        synchronized int consume() {}
//    }
//
//    public static void main(String[] args) {
//        SharedResource sr = new SharedResource();
//        Thread producer = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                sr.produce(i);
//            }
//        });
//
//        Thread consumer = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                sr.consume();
//            }
//        });
//
//        producer.start();
//        consumer.start();
//    }
//
//    // t1 -> t2 -> t3
//}
