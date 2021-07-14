package String;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;

        int n = s.length();

        int j = n-1;

        while(j >= 0 && s.charAt(j) == ' ')
        {
            j--;
        }

        int count = 0;

        while(j >= 0 && s.charAt(j) != ' ')
        {
            count++;
            j--;
        }

        return count;
    }
}
