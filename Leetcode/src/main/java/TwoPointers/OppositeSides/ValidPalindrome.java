package TwoPointers.OppositeSides;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while(left < right)
        {
            while(left < right && !Character.isLetterOrDigit(arr[left]))
            {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(arr[right]))
            {
                right--;
            }

            if (left < right &&
                    Character.toLowerCase(arr[left++]) != Character.toLowerCase(arr[right--]))
            {
                return false;
            }
        }

        return true;
    }
}
