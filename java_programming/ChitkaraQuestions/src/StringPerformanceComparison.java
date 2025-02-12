public class StringPerformanceComparison {
    public static void main(String[] args) {
        long start, end;
        String str = "";
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            str += "a";
        }
        end = System.nanoTime();
        System.out.println("String Time: " + (end - start) + " ns");

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 10000; i < 20000; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) + " ns");

        StringBuffer sbf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 20000; i < 30000; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) + " ns");
    }
}
