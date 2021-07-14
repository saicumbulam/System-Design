package Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';

            if (i == s.length() - 1 || !Character.isDigit(c) && c != ' ')
            {
                if(sign == '+')
                {
                    sum+=tempSum;
                    tempSum = num;
                }
                else if(sign ==  '-')
                {
                    sum+=tempSum;
                    tempSum = -num;
                }
                else if (sign ==  '*')
                {
                    tempSum *= num;
                }
                else if (sign ==  '/')
                {
                    tempSum /= num;
                }
                sign = c;
                num=0;
            }
        }

        sum+=tempSum;
        return sum;
    }
}
