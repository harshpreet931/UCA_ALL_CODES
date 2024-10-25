package java_programming.riteshsir.cars;

public class test {
    public static void main(String[] args) {
        test t = new test();
        t.callCar(new car());
        t.callCar(new maruti());
        t.callCar(new mercedes());
    }

    public void callCar(car c) {
        System.out.println(c.hashCode());
        System.out.println(c.getClass().getName());
        c.m1();
        c.m2();

        if(c instanceof maruti)
        {
            maruti m = (maruti)c;
            System.out.println(m.hashCode());
            m.m1();
            m.m2();
            m.m3();
        }
        else
        {
            System.out.println("I am not maruti: " + c.getClass().getName());
        }

        System.out.println();
    }
}
