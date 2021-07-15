package TwoPointers;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int max_value = 0;
        for(int num: heights)
        {
            max_value = Math.max(max_value, num);
        }
        int[] map = new int[max_value];
        for(int h: heights) map[h]--;

        int res = 0;
        // use pointer to represent the next number
        int h_ptr = 1;

        for(int h: heights) {
            while(map[h_ptr] == 0)
            {
                h_ptr++;
            }


            if(h_ptr != h) {
                ++res;
            }

            map[h_ptr]--;
        }

        return res;
    }
}
