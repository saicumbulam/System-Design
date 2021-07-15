package Trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    class TrieNode
    {
        TrieNode[] children;
        boolean isEndWord;
        String word;

        public TrieNode()
        {
            children = new TrieNode[26];
            isEndWord = false;
            word = null;
        }
    }

    class Trie
    {
        TrieNode root;

        public Trie(){ root = new TrieNode(); }

        public int getIndex(char x)
        {
            return x - 'a';
        }

        public void add(String str)
        {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++)
            {
                int index = getIndex(str.charAt(i));
                if(curr.children[index] == null)
                {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }

            curr.isEndWord = true;
            curr.word = str;
        }


        public void GetList(TrieNode curr, List<String> list)
        {
            if(curr == null || list.size() >= 3)
            {
                return;
            }
            if(curr.isEndWord)
            {
                list.add(curr.word);
            }

            for(TrieNode child: curr.children)
            {
                if(child != null)
                {
                    GetList(child, list);
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        for(int i = 0; i < products.length; i++)
        {
            trie.add(products[i]);
        }

        TrieNode curr = trie.root;
        List<TrieNode> rootsList = new ArrayList<>();
        for (int i=0; i< searchWord.length(); i++) {
            curr = curr.children[searchWord.charAt(i) - 'a'];
            if (curr == null) break;
            rootsList.add(curr);
        }


        List<List<String>> result = new ArrayList<>();

        for(int i = 0 ; i < rootsList.size(); i++)
        {
            List<String> list = new ArrayList<>();
            trie.GetList(rootsList.get(i), list);
            result.add(list);
        }

        while(result.size() < searchWord.length())
        {
            result.add(new ArrayList<>());
        }

        return result;
    }
}
