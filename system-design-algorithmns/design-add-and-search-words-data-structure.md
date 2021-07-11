# Design Add and Search Words Data Structure

```java
class WordDictionary {

    class TrieNode
    {
        boolean isWord;
        String word;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
            word = "";
            isWord = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    
    private int getIndex(char x)
    {
        return x - 'a';
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        System.out.println(word);
        
        for(int i = 0; i < word.length(); i++)
        {
            int index = getIndex(word.charAt(i));
            if (curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
        curr.word = word;
    }
    
    public boolean search(String word) {
        return Calc(root, word, 0);
    }
    
    private boolean Calc(TrieNode root, String word, int index)
    {
        TrieNode curr = root;
        
        for(int i = index; i < word.length(); i++)
        {
            char c = word.charAt(i);
            
            if (c == '.')
            {
                for(TrieNode child: curr.children)
                {
                    if (child != null)
                    {
                         if (Calc(child, word, i+1))
                        {
                            return true;   
                        }                          
                    }
                }
                return false;
            }
            else if (curr.children[getIndex(c)] == null)
            {
                return false;
            }
            else
            {
                curr = curr.children[getIndex(c)];
            }            
        }
        return curr.isWord == true;        
    }
}
```

