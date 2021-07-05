package Amazon;

import java.util.Arrays;

public class ThreeProduct {
    public static void main(String[] args) {
       int[] arr = {1,6,9,4,2,3};
        int target = 24;
        System.out.println(Calculate(arr, target));
    }

    static int count = 0;
    private static int Calculate(int[] arr, int target)
    {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            if(i > 0 && arr[i] == arr[i-1])
            {
                continue;
            }
            Calculate1(arr, i,i+1, target);
        }
        return count;
    }

    private static void Calculate1(int[] arr, int curr, int left, int target)
    {
        int right = arr.length-1;
        while (left < right)
        {
            int sum = arr[curr] * arr[left] * arr[right];

            if (sum == target)
            {
                System.out.println(String.format("%d, %d, %d", arr[curr], arr[left], arr[right]));
                count++;
            }

            if (target > sum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}
