package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//o(4^n * n) | o(n)
public class LetterCombinationsofaPhoneNumber {
    List<String> result = new ArrayList<>();
    HashMap<String, List<String>> map;

    public List<String> letterCombinations(String s)
    {
        if (s == null || s.equals("") ) return  result;
        map = new HashMap<>();
        map.put("1", new ArrayList<>());
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r", "s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y", "z"));

        Calculate(s, new StringBuilder());
        return result;
    }

    private void Calculate(String s, StringBuilder curr) {
        if (s.isEmpty())
        {
            result.add(curr.toString());
            return;
        }

        String c = String.valueOf(s.charAt(0));

        s = s.substring(1);
        for (String item: map.get(c))
        {
            curr.append(item);
            Calculate(s, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
