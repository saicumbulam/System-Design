package BinarySearch;

//TODO: Study
//might be duplicates present
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while ( start <= end)
        {
            int mid = start + (end - start)/2;

            if (nums[mid] == target)
            {
                return true;
            }

            if (nums[start] == nums[mid] && nums[end] == nums[mid])
            {
                start++;
                end--;
            }
            else if (nums[start] <= nums[mid])
            {
                if (target >= nums[start] && target < nums[mid])
                {
                    end = mid -1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else
            {
                if (target > nums[mid] && target <= nums[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid -1;
                }

            }
        }

        return false;
    }
}
