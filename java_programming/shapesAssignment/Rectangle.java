public class Rectangle extends Quadrilateral
{
    public Rectangle(double side1, double side2)
    {
        super(side1, side2, side1, side2);
    }

    public double area()
    {
        return side1 * side2;
    }
}