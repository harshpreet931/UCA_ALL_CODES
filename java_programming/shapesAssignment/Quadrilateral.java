public abstract class Quadrilateral implements Shapes
{
    protected double side1, side2, side3, side4;

    public Quadrilateral(double side1, double side2, double side3, double side4)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    public double perimeter()
    {
        return side1 + side2 + side3 + side4;
    }

    public abstract double area();
}
