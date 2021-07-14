package TwoPointers;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int nextElement = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (val != nums[i])
            {
                nums[nextElement++] = nums[i];
            }
        }
        return nextElement;
    }
}
