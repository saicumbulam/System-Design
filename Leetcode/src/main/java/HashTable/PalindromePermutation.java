package HashTable;

import java.util.HashSet;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c: s.toCharArray())
        {
            if (set.contains(c))
            {
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }

        if (set.size() == 1 || set.isEmpty())
        {
            return true;
        }

        return false;
    }
}
