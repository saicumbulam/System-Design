package Design;

import java.util.Stack;

public class MinStack {
    class Minstack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public Minstack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(minStack.isEmpty() || val <= minStack.peek())
            {
                minStack.push(val);
            }
        }

        public void pop() {
            int temp = stack.pop();
            if(minStack.peek() == temp)
            {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if(minStack.isEmpty()) return -1;
            return minStack.peek();
        }
    }
}
