# Implement Queue using Stacks

```java
class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        
        stack2.push(x);
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        
    }
    
    /** Removes the element from in 
    front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.size() == 0;
    }
}
```

