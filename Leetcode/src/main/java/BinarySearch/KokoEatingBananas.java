package BinarySearch;

/*
Input: piles = [3,6,7,11], h = 8
Output: 4
minimum integer k such that she can eat all the bananas within h hours.
**/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++)
        {
            right = Math.max(right, piles[i]);
        }

        while(left < right)
        {
            int mid = left + (right-left)/2;

            if(enough(piles, mid, H))
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }

        return left;
    }

    private boolean enough(int[] piles, int mid, int H)
    {
        int count = 0;

        for(int i = 0; i < piles.length; i++)
        {
            count += piles[i]/mid;
            if(piles[i] % mid != 0)
            {
                count++;
            }
        }

        return count <= H;
    }
}
