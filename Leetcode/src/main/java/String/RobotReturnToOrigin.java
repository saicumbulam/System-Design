package String;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] source = new int[] {0,0};

        for (int i = 0; i < moves.length(); i++)
        {
            char c = moves.charAt(i);

            if (c == 'U')
            {
                source[0] += 1;
            }
            else if (c == 'D')
            {
                source[0] -= 1;
            }
            else if (c == 'R')
            {
                source[1] += 1;
            }
            else if (c == 'L')
            {
                source[1] -= 1;
            }

        }

        if (source [0] == 0  && source[1] == 0) return true;

        return false;
    }
}

