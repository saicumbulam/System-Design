package Amazon;

public class SqauredShortestDistance {
    public static void main(String[] args) {
        int numRobots = 3;
        int[] positionX = {0,1,2};
        int[] positionY = {0,1,4};
        Calculate(numRobots, positionX, positionY);
    }

    private static void Calculate(int num, int[] x, int[] y)
    {
        for(int i = 0; i < num; i++)
        {

        }
    }
}

class Robot
{
    int x;
    int y;
    int distance;

    public Robot(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Robot o)
    {
        return (int) (Math.pow((x - o.x),2) + Math.pow((y - o.y),2));
    }
}
