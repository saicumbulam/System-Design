package ExpandCenter;

public class PalindromeSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++)
        {
            count += Finder(s, i, i+1);
            count += Finder(s, i, i);
        }

        return count;
    }


    private int Finder(String s, int left, int right)
    {
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
