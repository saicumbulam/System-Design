package TwoPointers.RemoveDuplicates;

//Given an integer array nums sorted in non-decreasing order, remove
// some duplicates in-place such that
// each unique element appears at most twice
public class RemoveDuplicatesfromSortedArrayII
{
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i-1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if (count <= 2)
            {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
