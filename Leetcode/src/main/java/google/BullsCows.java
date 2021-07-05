package google;

import java.util.HashMap;

public class BullsCows {
    public static void main(String[] args) {
        String secret = "1807", guess = "7810";

        System.out.println(Calc(secret, guess));
    }

    private static String Calc(String secret, String guess)
    {
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
                {
                    cows--;
                }
            }
            else
            {
                cows++;
            }
            map.put(c, map.get(c)-1);
        }

        return bulls + "A" + cows + "B";
    }
}
