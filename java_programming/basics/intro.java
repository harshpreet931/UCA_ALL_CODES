class intro {
    public int add(int a, int b)
    {
        return a + b;
    }

    public static void main(String[] args) {
        intro obj = new intro();
        System.out.println(obj.add(10, 20));

        System.out.println(test.sub(20, 10));

        test2 obj2 = new test2();
        System.out.println(obj2.mul(10, 20));
    }
}

class test {
    public static int sub(int a, int b)
    {
        return a - b;
    }
}

class test2 {
    public int mul(int a, int b)
    {
        return a * b;
    }
}