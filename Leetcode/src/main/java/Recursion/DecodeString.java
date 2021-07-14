package Recursion;

import java.util.LinkedList;
import java.util.Queue;

//O(maxK⋅n) | o(n)
public class DecodeString {
    public String decodeString(String s) {

        Queue<Character> queue = new LinkedList<>();
        for(char c: s.toCharArray())
        {
            queue.add(c);
        }
        return Calculate(queue);
    }

    private String Calculate(Queue<Character> queue)
    {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while(!queue.isEmpty())
        {
            char c = queue.poll();
            if(Character.isDigit(c))
            {
                num = num*10 + Character.getNumericValue(c);
            }
            else if (c == '[')
            {
                String sub = Calculate(queue);
                for(int i = 0; i < num; i++)
                {
                    sb.append(sub);
                }
                num = 0;
            }
            else if (c == ']')
            {
                break;
            }
            else
            {
                sb.append(c);
            }

        }

        return sb.toString();
    }
}
