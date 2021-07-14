package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str: tokens)
        {
            if (str.equals("+") || str.equals("-") ||
                    str.equals("*") || str.equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();

                if(str.equals("+"))
                {
                    stack.push(a+b);
                }
                else if (str.equals("-"))
                {
                    stack.push(b-a);
                }
                else if (str.equals("*"))
                {
                    stack.push(a*b);
                }
                else if(str.equals("/"))
                {
                    stack.push(b/a);
                }

            }
            else
            {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }
}
