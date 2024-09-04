public class modular_exponentiation {
    public static void main(String[] args) {
        System.out.println(modExp(2, 5, 13));
    }
    public static long modExp(int x, int y, int p) {
        long res = 1;
        while(y > 0) {
            if((y & 1) == 1) res = (res * x) % p;
            x = (x * x) % p;
            y = y >> 1;
        }
        return res;
    }
}
