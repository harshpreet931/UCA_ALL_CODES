public class Parallelogram extends Quadrilateral 
{
    private double height;
    
    public Parallelogram(double base, double side, double height)
    {
        super(base, side, base, side);
        this.height = height;
    }

    public double area()
    {
        return side1 * height;
    }
}
