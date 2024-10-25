public class Main {
    public static void main(String[] args) {
        Shapes circle = new Circle(5);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        Shapes triangle = new EquilateralTriange(3);
        System.out.println("Triangle Area: " + triangle.area());

        Shapes rectangle = new Rectangle(4, 5);
        System.out.println("Rectangle Area: " + rectangle.area());

        Shapes square = new Square(4);
        System.out.println("Square Area: " + square.area());

        Shapes parallelogram = new Parallelogram(4, 5, 30);
        System.out.println("Parallelogram Area: " + parallelogram.area());

        Shapes trap = new Trapezium(10, 10, 12, 10, 10);
        System.out.println("Trapezium Area: " + trap.area());

        Shapes scaleneT = new ScaleneTriangle(10, 12, 14);
        System.out.println("Scalene Triangle Area: " + scaleneT.area());
    }
}
