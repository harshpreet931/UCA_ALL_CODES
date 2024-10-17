package java_programming.interface2;

public class interfaceExample {
    public static void main(String[] args) {
        Calculator c = new Harsh();
        System.out.println(c.add(2, 3));
        System.out.println(c.sub(2, 3));
    }
}

interface Calculator {
    public int add(int a, int b);
    public int sub(int a, int b);
}

class Harsh implements Calculator{
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}
