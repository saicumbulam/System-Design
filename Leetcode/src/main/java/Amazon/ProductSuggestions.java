package Amazon;

import java.util.ArrayList;
import java.util.List;

public class ProductSuggestions {
    public static void main(String[] args) {
        String[] keywords = new String[] {"mobile","mouse",
                "moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(Calculate(keywords, searchWord));
    }

    static List<List<String>> result = new ArrayList<>();
    static TrieNode root = new TrieNode();

    private static List<List<String>> Calculate(String[] products,
                                                String str)
    {
        for(String word: products)
        {
            insert(word);
        }
        List<TrieNode> list = new ArrayList<>();
        TrieNode curr = root;

        for(int i = 0; i < str.length(); i++)
        {
            int index = getIndex(str.charAt(i));
            if(curr.children[index] == null)
            {
                break;
            }
            curr = curr.children[index];
            list.add(curr);
        }

        for(TrieNode node: list)
        {
            List<String> temp = new ArrayList<>();
            Calculate1(node, temp);
            result.add(temp);
        }

        return result;
    }

    private static void Calculate1(TrieNode curr, List<String> list)
    {
        if(list.size() >= 3 || curr == null) return;
        if(curr.isEndWord)
        {
            list.add(curr.word);
        }

        for (TrieNode child: curr.children)
        {
            Calculate1(child, list);
        }
    }

    private static int getIndex(char x)
    {
        return x - 'a';
    }

    private static void insert(String word)
    {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            int index = getIndex(word.charAt(i));
            if(curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndWord = true;
        curr.word = word;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean isEndWord;
    String word;

    public TrieNode()
    {
        children = new TrieNode[26];
        isEndWord = false;
        word = "";
    }
}