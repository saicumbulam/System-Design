package Amazon;

public class MusicPair {
    public static void main(String[] args) {
        System.out.println(Calculate(new int[]{30,20,150,100,40}));
    }

    private static int Calculate(int[] arr)
    {
        int[] remainders = new int[60];
        int count = 0;
        for (int t: arr) {
            if (t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}
