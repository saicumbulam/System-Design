package Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubStringsSizeKDistinctCharacters {
    public static void main(String[] args) {
        String str = "aabcdbcd";
        int k = 3;
        System.out.println(Calculate(str, k));
    }

    private static List<String> Calculate(String str, int k)
    {
        HashSet<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            while (sb.length() > k)
            {
                sb.deleteCharAt(0);
            }
            if (sb.length() == k && Unique(sb.toString()))
            {
                result.add(sb.toString());
            }
        }
        return new ArrayList<>(result);
    }

    private static boolean Unique(String str) {
        HashSet<Character> set = new HashSet<>();
        for(char c: str.toCharArray())
        {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
