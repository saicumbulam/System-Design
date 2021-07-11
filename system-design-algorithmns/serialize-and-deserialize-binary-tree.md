# Serialize and Deserialize Binary Tree

```java
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Helper(root, list);
        return String.join(",", list);
    }
    
    private void Helper(TreeNode root, List<String> list)
    {
        if(root == null)
        {
            list.add("#");
            return;
        }
        
        list.add(root.val + "");

            Helper(root.left, list);
            Helper(root.right, list);          

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] split = data.split(",");
        
        if(split[0].equals("#")) return null;
        
        return Finder(split);
    }
    
    int index = 0;
    private TreeNode Finder(String[] arr)
    {
        if(index >= arr.length || arr[index].equals("#"))
        {
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = Finder(arr);
        root.right = Finder(arr);
        return root;
    }
}
```

