package Math;

import java.util.Random;

public class ShuffleanArray {
    int[] nums;
    int[] org;
    Random random;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.org = this.nums.clone(); //need to put clone
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.nums = org;
        this.org = org.clone();
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < nums.length; i++)
        {
            Swap(i, getRandom(i, nums.length));
        }
        return nums;
    }

    private int getRandom(int start, int end)
    {
        return start + random.nextInt(end - start);
    }

    private void Swap(int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
