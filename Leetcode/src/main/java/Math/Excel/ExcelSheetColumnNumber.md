package Math.Excel;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String str) {
        int sum = 0;

        for(int i = 0; i < str.length(); i++)
        {
            sum *= 26;
            sum += str.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
