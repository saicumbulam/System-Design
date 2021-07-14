package Graph;

public class FindtheCelebrity {
    int n = 0;
    public int findCelebrity(int n) {
        this.n = n;
        int celebrity = 0;
        for (int i = 0; i< n; i++)
        {
            if (knows(celebrity, i))
            {
                celebrity = i;
            }
        }


        if (!Check(celebrity))
        {
            return -1;
        }
        return celebrity;
    }

    private boolean knows(int celebrity, int i) {
        return true;
    }

    private boolean Check(int i)
    {
        for (int j = 0; j< n; j++)
        {
            if (i == j)
            {
                continue;
            }
            if (knows(i,j) || !knows(j, i))
            {
                return false;
            }
        }

        return true;
    }
}
