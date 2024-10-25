public class EquilateralTriange extends Triangle 
{
    public EquilateralTriange(double side)
    {
        super(side, side, side);
    }    

    public double area()
    {
        return (Math.sqrt(3) / 4) * Math.pow(side1, 2);
    }
}
