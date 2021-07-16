```java
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int c1 = -1;
        int c2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++)
        {
            if (word1.equals(wordsDict[i]))
            {
                c1 = i;
            }

            if (word2.equals(wordsDict[i]))
            {
                c2 = i;
            }

            if(c1 != -1 && c2 != -1)
            {
                min = Math.min(min, Math.abs(c1 - c2));
            }
        }

        return min;
    }
}
```