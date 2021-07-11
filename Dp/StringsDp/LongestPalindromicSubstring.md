package Dp.StringsDp;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            //int len1 = palindrome(str, i, i);
            //int len2 = palindrome(str, i, i+1);
            //int len = Math.max(len1, len2);
        }

        return str.substring(start, end + 1);
    }
}
