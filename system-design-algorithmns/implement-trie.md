# Implement Trie

```java
class Trie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();    
    }
    
    private int getIndex(char x)
    {
        return x - 'a';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            int index = getIndex(word.charAt(i));
            if (curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            int index = getIndex(word.charAt(i));
            if (curr.children[index] == null)
            {
                return false;
            }
            curr = curr.children[index];
        }
        
        return curr.isEnd;        
    }
    
    /** Returns if there is any word in 
    the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i = 0; i < prefix.length(); i++)
        {
            int index = getIndex(prefix.charAt(i));
            if (curr.children[index] == null)
            {
                return false;
            }
            curr = curr.children[index];
        }
        
        return true;              
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode()
    {
        children = new TrieNode[26];
    }
}
```

