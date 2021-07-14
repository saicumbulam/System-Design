package TwoPointers;

//o(n) | o(1)
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while(i >= 0 && nums[i] >= nums[i+1])
        {
            i--;
        }

        if (i >= 0)
        {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i])
            {
                j--;
            }
            Swap(nums, i, j);
        }

        Reverse(nums, i+1);
    }

    private void Reverse(int[] nums, int start)
    {
        int end = nums.length-1;
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    private void Swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
