package HashTable;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
