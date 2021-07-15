package ExpandCenter;

public class LongestPalindromicSubstring {
    // for cbbd => the would be
    // debug1: 0|1|0|1
    // debug2: 0|0|0
    // debug1: 1|1|2|2
    // debug2: 1|1|2
    // debug1: 2|1|0|1
    // debug1: 3|1|0|1
    // len1 will expand from current index, len2 will expand from current and next index.
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            System.out.println("debug1: " + i + "|" + len1 + "|" + len2 + "|" + len);
            if (len > end - start)
            {

                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println("debug2: " + i + "|" +  start + "|" + end);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
