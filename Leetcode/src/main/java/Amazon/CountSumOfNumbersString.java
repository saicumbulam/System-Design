package Amazon;

public class CountSumOfNumbersString {
    public static void main(String[] args) {
        String str =  "go786sun2bob";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        char[] arr = str.toCharArray();
        int i = 0;
        int num = 0;

        while(i < arr.length)
        {
            int digit = 0;
            if(Character.isDigit(arr[i]))
            {
                while (i < arr.length && Character.isDigit(arr[i]))
                {
                    digit = digit*10 + Character.getNumericValue(arr[i]);
                    i++;
                }
                num += digit;
            }
            else
            {
                i++;
            }
        }

        return num;
    }
}
