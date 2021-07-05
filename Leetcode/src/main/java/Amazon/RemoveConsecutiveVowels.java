package Amazon;

public class RemoveConsecutiveVowels {
    public static void main(String[] args) {
        String str =  "saalt";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length())
        {
            char c = str.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i'
            || c =='o' || c == 'u')
            {
                while (i < str.length() && c == str.charAt(i))
                {
                    i++;
                }
            }
            else
            {
                i++;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
