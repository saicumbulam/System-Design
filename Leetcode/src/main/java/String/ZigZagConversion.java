package String;

//o(n) | o(n) where n is length of string
/*
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
P   A   H   N
A P L S I I G
Y   I   R
* */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int j = 0; j < nRows && i < len; j++) // vertically down
                sb[j].append(c[i++]);
            for (int j = nRows-2; j >= 1 && i < len; j--) // obliquely up
                sb[j].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
