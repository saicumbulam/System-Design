package Design;

public class RobotBoundedInCircle {
    // make the robot move in a 4 quadrant.
    // idx + 3 and idx + 1 means getting directions from directions
    // correct the direction by turning left/right/south and move only when {0,1}
    // left is west side and right is east side
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
            {
                idx = (idx + 3) % 4;
                //System.out.println(i);
                //System.out.println(idx);
            }
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}
