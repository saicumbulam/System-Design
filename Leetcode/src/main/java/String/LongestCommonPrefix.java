package String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        {
            return "";
        }

        if(strs.length == 1)
        {
            return strs[0];
        }

        StringBuilder result = new StringBuilder();
        int index = 0;

        for(char c: strs[0].toCharArray())
        {
            for (int i = 1; i < strs.length; i++)
            {
                if (index >= strs[i].length() || strs[i].charAt(index) != c)
                {
                    return result.toString();
                }
            }
            index++;
            result.append(c);
        }
        return result.toString();
    }
}
