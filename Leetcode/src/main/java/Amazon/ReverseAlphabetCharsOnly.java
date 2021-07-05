package Amazon;

public class ReverseAlphabetCharsOnly {
    public static void main(String[] args) {
        String str = "c@mbie!";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while (left < right)
        {
            while (left < arr.length && !Character.isAlphabetic(arr[left]))
            {
                left++;
            }

            if(left == arr.length-1)
            {
                break;
            }
            while (right >= 0 && !Character.isAlphabetic(arr[right]))
            {
                right--;
            }

            if(left < right)
            {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
