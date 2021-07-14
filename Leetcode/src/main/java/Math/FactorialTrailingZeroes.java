package Math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int currentMultiple = 5;
        int count = 0;

        while(n >= currentMultiple)
        {
            count += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return count;
    }
}
