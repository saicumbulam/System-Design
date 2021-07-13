package String;

public class StringtoInteger {
    public int myAtoi(String s) {
        int i = 0;
        while( i < s.length() && s.charAt(i) == ' ')
        {
            i++;
        }

        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
        {
            sign = s.charAt(i) == '-' ? -1: 1;
            i++;
        }

        int value = 0;

        while(i < s.length() && Character.isDigit(s.charAt(i)))
        {
            if(value > Integer.MAX_VALUE/10 || (value == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE%10))
            {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            value = value*10 + (s.charAt(i++) - '0');

        }


        return sign*value;
    }
}
