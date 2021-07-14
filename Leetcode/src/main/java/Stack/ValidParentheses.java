package Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray())
        {
            if(c == ')' || c == ']' || c == '}')
            {
                if(stack.isEmpty()) return false;

                if((c == ')' && stack.pop() != '(')
                        || (c == ']' && stack.pop() != '[')
                        || (c == '}' && stack.pop() != '{'))
                {
                    return false;
                }
            }
            else
            {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
