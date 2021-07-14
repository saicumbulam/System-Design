package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                result[i] = 0;
            }
            else
            {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return result;

    }
}
