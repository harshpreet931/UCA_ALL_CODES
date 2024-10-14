public class HelloWorld {
    public static void main(String[] args) {
        Hello hello = new Hello1();
        hello.foo();
        hello = new Hello2();
        hello.foo();
        // hello.foo2(); // error: cannot find symbol because foo2() is not defined in Hello interface
        hello.fooahaha();
    }
}
