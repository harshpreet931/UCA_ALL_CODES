public class Circle implements Shapes 
{
    protected double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double area()
    {
        return Math.PI * radius * radius;
    }

    public double perimeter()
    {
        return 2 * Math.PI * radius;
    }
}
