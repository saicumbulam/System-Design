package TwoPointers.ForwardPointers.Compression;

public class StringCompression {
    public int compress(char[] chars) {

        int i = 0;
        int index = 0;

        while(i < chars.length)
        {
            char c = chars[i];
            int count = 0;
            while( i < chars.length && chars[i] == c)
            {
                i++;
                count++;
            }

            if(count > 1)
            {
                chars[index++] = c;
                for(char item: String.valueOf(count).toCharArray())
                {
                    chars[index++] = item;
                }
            }
            else
            {
                chars[index++] = c;
            }
        }

        return index;
    }
}
