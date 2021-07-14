package Recursion;

public class Powxn {
    public double myPow(double x, int n) {
        if (n < 0)
        {
            x = 1/x;
            n *= -1;
        }

        return Find(x, n);
    }

    private double Find(double x, int n)
    {
        if (n == 0) return 1;

        double target = Find(x, n/2);

        if (n %2 == 0)
        {
            return target*target;
        }
        else
        {
            return x * target*target;
        }
    }
}
