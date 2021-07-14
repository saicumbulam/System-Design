package TwoPointers;

public class SortColors {
    public void sortColors(int[] nums) {
        int  i = 0;

        int left = 0;
        int right = nums.length-1;

        while(i <= right)
        {
            if (nums[i] == 0)
            {
                Swap(nums, i, left);
                left++;
                i++;
            }
            else if (nums[i] == 1)
            {
                i++;
            }
            else
            {
                Swap(nums, i, right);
                right--;
            }
        }
    }


    private void Swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
