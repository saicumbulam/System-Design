package Dp.SingleDP;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        // maintain the prev and curr pointer
        int prev = 1;
        int curr = 2;

        for(int i = 3; i <= n; i++)
        {
            int next = curr + prev; // calculate next step from curr and prev
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
