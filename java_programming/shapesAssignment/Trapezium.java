public class Trapezium extends Quadrilateral 
{
    private double height;
    
    public Trapezium(double base1, double base2, double side1, double side2, double height)
    {
        super(base1, base2, side1, side2);
        this.height = height;
    }

    public double area()
    {
        return (side1 + side2) * height / 2;
    }
}
