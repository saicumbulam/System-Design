package TwoPointers.ForwardPointers.Compression;

import java.util.ArrayList;
import java.util.List;

/*
* ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
Output
[null, "L", "e", "e", "t", "C", "o", true, "d", true]
* */
class StringIterator {

    List<Character> list = new ArrayList<>();

    public StringIterator(String compressedString) {
        if (compressedString == null) return;

        int i = 0;
        while(i < compressedString.length())
        {
            int count = 0;
            char c = compressedString.charAt(i);
            while (i < compressedString.length() && compressedString.charAt(i) == c)
            {
                count++;
            }
        }

    }

    public char next() {
        if (hasNext())
        {
            return list.remove(0);
        }
        return ' ';
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
