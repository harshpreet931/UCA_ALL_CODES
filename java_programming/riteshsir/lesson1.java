package java_programming.riteshsir;

public class lesson1 {
    // why is it public static void main?
    // public: So that JVM can access it from anywhere.
    // static: So that JVM can call it without creating an object of the class. why are we not making an object? Because the main method is called by JVM before any objects are created.
    // if not static, JVM would have problem with Constructor functions...
    // void: It does not return anything.
    // main: It is the name of the method.
    // String[] args: It is the parameter of the method. It is an array of strings.
    public static void main(String[] args)
    {
        System.out.println("Hello World");
    }
}
