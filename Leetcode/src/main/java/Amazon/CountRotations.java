package Amazon;

public class CountRotations {
    public static void main(String[] args) {
        int res = countRotations(new int[] {100, 12, 50});
        System.out.println(res);
    }

    public static int countRotations(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while(left < right)
        {
            int mid = left + ((right-left)/2);
            if (arr[mid] < arr[mid+1])
            {
                return mid;
            }
            if (arr[mid-1] > arr[mid])
            {
                return mid;
            }

            if (arr[left] < arr[mid])
            {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
