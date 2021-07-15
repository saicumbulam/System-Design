package Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().c == ch)
            {
                stack.peek().count += 1;
            }
            else
            {
                stack.push(new Node(ch, 1));
            }

            if(stack.peek().count == k)
            {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        for (Node temp: stack)
        {
            for (int i = 0; i < temp.count; i++)
            {
                result.append(String.valueOf(temp.c));
            }

        }
        return result.toString();
    }

    class Node
    {
        Character c;
        int count;

        public Node(Character c, int count)
        {
            this.c = c;
            this.count = count;
        }
    }
}
