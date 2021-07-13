package BitManipulation;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0)
        {
            n &= (n-1);
            count++;
        }
        return count;
    }
}
