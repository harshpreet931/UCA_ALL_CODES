package java_programming.riteshsir;
import java.util.*;

public class classLoader {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String s = "abcd";

        System.out.println(s.getClass().getClassLoader());
        System.out.println(s.getClass().getResource("String.class"));
        System.out.println(String.class.getClassLoader());
        System.out.println(List.class.getClassLoader());
    }
}
