package Amazon;

public class CompareProduct {
    public static void main(String[] args) {

        //int number = 2421;
        int number = 4;
        boolean res = compareProduct(number);
        System.out.println(res);
    }

    private static boolean compareProduct(int num)
    {
        boolean odd = false;
        int oddProd = 1;
        int evenProd = 1;

        while (num != 0 )
        {
            int digit = num%10;
            if (odd)
            {
                oddProd *= digit;
            }
            else
            {
                evenProd *= digit;
            }
            odd = !odd;
            num = num/10;

        }

        return oddProd == evenProd;
    }
}
