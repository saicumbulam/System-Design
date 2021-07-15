/*
Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

* */
package FastSlow;

//TODO: Study
public class CycleCircularArray {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int slow = i;
            int fast = i;
            int direction = nums[i] < 0 ? -1 : 1;

            do
            {
                slow = finder(nums, slow, direction);
                fast = finder(nums, fast, direction);
                if (fast != -1)
                {
                    fast = finder(nums, fast, direction);
                }
            }
            while(slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
            {
                return true;
            }
        }

        return false;
    }


    private int finder(int[] nums, int index, int direction)
    {
        int nextDirection = nums[index] < 0 ? -1: 1;


        if (direction != nextDirection) return -1;

        int nextIndex = nums[index] + index;
        nextIndex %= nums.length;
        if (nextIndex < 0) nextIndex += nums.length;

        if (nextIndex == index) return -1;

        return nextIndex;

    }
}
