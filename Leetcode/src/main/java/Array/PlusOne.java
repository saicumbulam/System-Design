package Array;

public class PlusOne {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0; i--)
        {
            if (digits[i] > 8)
            {
                digits[i] = 0;
            }
            else
            {
                digits[i] += 1;
                return digits;
            }
        }

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
