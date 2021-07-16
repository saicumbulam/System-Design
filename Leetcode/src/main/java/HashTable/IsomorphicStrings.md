package HashTable;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return Calculate(s,t) && Calculate(t,s);
    }

    private static boolean Calculate(String s, String t)
    {
        HashMap<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);

            if (!hashMap.containsKey(from))
            {
                hashMap.put(from, to);
            }
            else if (hashMap.get(from) != to) {
                return false;
            }
        }
        return true;
    }
}
