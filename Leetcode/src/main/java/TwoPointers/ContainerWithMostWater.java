package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] ans) {
        int maxArea = 0;
        int left = 0;
        int right = ans.length-1;

        while(left < right)
        {
            maxArea = Math.max(maxArea, (right - left)
                    * Math.min(ans[right], ans[left]));
            if (ans[left] < ans[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return maxArea;
    }
}
