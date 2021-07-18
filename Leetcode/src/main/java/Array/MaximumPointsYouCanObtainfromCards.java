package Array;

import java.util.Arrays;

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        // If no cards or number of cards to pick more than available just return 0
        if (cardPoints == null || k <= 0 || k > cardPoints.length) return 0;

        // If k equals total number of cards simply sum up all cards
        if (k == cardPoints.length) return Arrays.stream(cardPoints).sum();

        // Initialize max points as min val
        int maxPoints = Integer.MIN_VALUE;

        // Prefix sum of left cards - we can pick 0 or 1 or 2 ... k cards from left
        int[] left = new int[k+1];
        for (int i = 1; i <= k; i++) {
            left[i] = left[i-1] + cardPoints[i-1];
        }
        // Prefix sum from right - Can pick 0, 1, ... k number of cards from right
        int[] right = new int[k+1];
        for (int i = 1; i <= k; i++) {
            right[i] = right[i-1] + cardPoints[cardPoints.length-i];
        }

        // Iterate over possibilities - 0 from left and remaining from right and so on
        for (int i = 0; i <= k; i++) {
            maxPoints = Math.max(maxPoints, left[i] + right[k-i]);
        }
        return maxPoints;
    }
}
