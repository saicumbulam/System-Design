
```java
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = BinarySearch(nums, target, true);
        if (result[0] == -1)
        {
            return new int[]{-1, -1};
        }

        result[1] = BinarySearch(nums, target, false);

        return result;
    }

    private int BinarySearch(int[] nums, int target, boolean before)
    {
        int start = 0, end = nums.length-1;
        int keyIndex = -1;

        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (nums[mid] == target)
            {
                keyIndex = mid;

                if (before)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else if (nums[mid] > target)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return keyIndex;
    }
}

```
