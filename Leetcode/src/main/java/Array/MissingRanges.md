

```java
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if(nums == null || nums.length == 0)
        {
            result.add(missingRange(lower, upper));
            return result;
        }

        if (nums[0] > lower)
        {
            result.add(missingRange(lower, nums[0]-1));
        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(missingRange(nums[i]+1, nums[i+1]-1));
            }
        }

        if (nums[nums.length-1] < upper)
        {
            result.add(missingRange(nums[nums.length-1] + 1, upper));
        }

        return result;
    }

    private String missingRange(int num1, int num2)
    {
        if(num1 == num2)
        {
            return String.valueOf(num1);
        }
        else
        {
            return String.format("%d->%d",num1, num2);
        }
    }
}
```