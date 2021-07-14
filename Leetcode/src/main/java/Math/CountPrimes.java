package Math;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] count = new boolean[n+1];
        int size = 0;

        for(int i = 2; i < n; i++)
        {
            if(count[i]) continue;
            size++;
            for(int j = 2; i * j < n; j++)
            {
                count[i*j] = true;
            }
        }
        return size;
    }
}
