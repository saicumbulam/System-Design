package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 0)
            {
                deque.addLast(arr[i]);
            }
            else
            {
                while(!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < Math.abs(arr[i]))
                {
                    deque.removeLast();
                }

                if (deque.isEmpty() || deque.peekLast() < 0)
                {
                    deque.addLast(arr[i]);
                }
                else if (deque.peekLast() == Math.abs(arr[i]))
                {
                    deque.removeLast();
                }
            }
        }

        int[] result = new int[deque.size()];
        int index = 0;

        while(!deque.isEmpty())
        {
            result[index++] = deque.removeFirst();
        }

        return result;
    }
}
