
```java
public class RotateArray {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = (k % n);
        if (k < 0)
        {
            k += n;
        }

        Calc(arr, 0, n-1);
        Calc(arr, 0, k-1);
        Calc(arr, k, n-1);
    }

    private void Calc(int[] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
```