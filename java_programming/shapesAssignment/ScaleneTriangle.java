public class ScaleneTriangle extends Triangle 
{
    public ScaleneTriangle(double side1, double side2, double side3)
    {
        super(side1, side2, side3);
    }
    
    public double area()
    {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}
