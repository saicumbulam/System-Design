# Binary Search Tree Iterator

```java
class BSTIterator {

    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        push();
    }
    
    public int next() 
    {
        if(!hasNext()) return -1;
        TreeNode temp = stack.pop();
        root = temp.right;
        push();
        return temp.val;
    }
    
    public void push()
    {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        if(stack.isEmpty() && root == null)
        {
            return false;
        }
        return true;
    }
}
```

