package String;

import java.util.HashMap;

/*
Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"
Explanation:
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".
* */
public class FindAndReplaceinString {
    class Element
    {
        String source;
        String target;

        public Element(String source, String target)
        {
            this.source = source;
            this.target = target;
        }
    }

    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {

        if(s.length() == 0) return "";

        StringBuilder result = new StringBuilder();

        HashMap<Integer, Element> map = new HashMap<>();
        for(int i = 0; i < indexes.length; i++)
        {
            map.put(indexes[i], new Element(sources[i], targets[i]));
        }

        int i = 0;

        while(i < s.length())
        {
            if (map.containsKey(i))
            {
                Element item = map.get(i);
                int len = item.source.length();
                if(i + len <= s.length() && s.substring(i, i+len).equals(item.source))
                {
                    result.append(item.target);
                    i += len;
                }
                else
                {
                    result.append(s.charAt(i));
                    i++;
                }
            }
            else
            {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
