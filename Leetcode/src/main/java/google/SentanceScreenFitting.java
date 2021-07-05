package google;

public class SentanceScreenFitting {
    public static void main(String[] args) {
        //String[] sentence = {"hello","world"};
        //int rows = 2, cols = 8;
        String[] sentence = {"a", "bcd", "e"};
        int rows = 3, cols = 6;
        String s= String.join(" ", sentence)+" ";
        int i=0, n=s.length();
        for (int r=0; r<rows; r++){
            i+=cols;
            //A single space must separate two consecutive words in a line.
            while (i>-1 && s.charAt(i%n)!=' ') i--;
            i++;
        }
        System.out.println(i/n);
    }

}
