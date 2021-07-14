package SlidingWindow;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals(""))
        {
            return 0;
        }

        if (needle == null || needle.equals(""))
        {
            return 0;
        }

        int windowStart = 0;

        StringBuilder temp = new StringBuilder();

        for(int windowEnd = 0; windowEnd < haystack.length(); windowEnd++)
        {
            temp.append(haystack.charAt(windowEnd));

            if (temp.toString().equals(needle))
            {
                return windowStart;
            }

            if(windowEnd - windowStart + 1 > needle.length()-1)
            {
                temp.deleteCharAt(0);
                windowStart++;
            }
        }

        return -1;
    }
}
