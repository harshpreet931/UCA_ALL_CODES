public class Square extends Quadrilateral 
{
    public Square(double side)
    {
        super(side, side, side, side);
    }

    public double area()
    {
        return side1 * side1;
    }
}
