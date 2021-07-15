package Stack;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i]))
            {
                stack.push(i);
            }
            else if (")".equals(arr[i]))
            {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = "";
                }
            }
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = "";
        }
        return String.join("", arr);
    }
}
