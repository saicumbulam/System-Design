package HashTable;

import java.util.HashMap;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: guess.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);

            if(c == guess.charAt(i))
            {
                bulls++;
                if (map.containsKey(c) && map.get(c) <= 0)
                    cows--;

            }
            else
            {

                if (map.containsKey(c) && map.get(c) > 0)
                    cows++;
            }
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)-1);
            }

        }

        return bulls + "A" + cows + "B";
    }
}
