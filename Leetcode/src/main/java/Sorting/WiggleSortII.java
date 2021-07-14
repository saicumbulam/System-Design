package Sorting;

//Input: nums = [1,5,1,1,6,4]
//Output: [1,6,1,5,1,4]
//Explanation: [1,4,1,5,1,6] is also accepted.

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int n = nums.length;
        int left = (n + 1) / 2 - 1; // median index
        int right = n - 1; // largest value index
        for (int i = 0; i < nums.length; i++)
        {   // copy large values on odd indexes
            if(i%2==1){
                nums[i] = copy[right];
                right--;
            } else{ // copy values decremeting from median on even indexes
                nums[i] = copy[left];
                left--;
            }
        }
    }
}
