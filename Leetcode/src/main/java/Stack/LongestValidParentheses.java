package Stack;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maximum = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                if(stack.isEmpty())
                {
                    stack.push(i);
                }
                maximum = Math.max(maximum, i - stack.peek());
            }
        }

        return maximum;
    }
}
