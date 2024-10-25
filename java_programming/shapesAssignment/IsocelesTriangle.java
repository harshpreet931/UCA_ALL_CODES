public class IsocelesTriangle extends Triangle 
{
    private double height;

    public IsocelesTriangle(double base, double side, double height)
    {
        super(base, side, side);
        this.height = height;
    }

    public double area()
    {
        return side1 * height / 2;
    }
}
