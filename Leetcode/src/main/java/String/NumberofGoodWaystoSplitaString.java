package String;

/*
Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
* */

import java.util.HashSet;
import java.util.Set;

//Similar to next array
public class NumberofGoodWaystoSplitaString {
    public int numSplits(String s) {
        Set<Character> unique = new HashSet<>();
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i=0; i<n; i++) {
            unique.add(s.charAt(i));
            prefix[i] = unique.size();
        }
        unique.clear();
        for(int i=n-1; i >= 0; i--) {
            unique.add(s.charAt(i));
            suffix[i] = unique.size();
        }

        int ans = 0;
        for(int i=1; i<n; i++) {
            if(prefix[i-1] == suffix[i]) {
                ans++;
            }
        }
        return ans;
    }
}
