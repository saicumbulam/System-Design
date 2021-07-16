package TwoPointers.ForwardPointers.Compression;

public class CountandSay {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1)
        {
            return result;
        }

        for(int i = 2; i <= n; i++)
        {
            String temp = "";
            int j = 0;
            while(j < result.length())
            {
                int count = 0;
                char c = result.charAt(j);
                while( j < result.length() && result.charAt(j) == c)
                {
                    count++;
                    j++;
                }
                temp += String.valueOf(count) + String.valueOf(c);
            }

            result = temp;
        }

        return result;
    }
}
