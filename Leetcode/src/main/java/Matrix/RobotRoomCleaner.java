package Matrix;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
      interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
              // Returns false if the cell in front is blocked and robot stays in the current cell.
              public boolean move();

              // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
      public void turnRight();

              // Clean the current cell.
        public void clean();
  }
    public int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }

    private void clean(Robot robot, int x, int y, int curDirection, Set<String> cleaned)
    {
        robot.clean();
        cleaned.add(x + " " + y);

        for (int i = 0; i < 4; i++) {
            int nx = x + DIRS[curDirection][0];
            int ny = y + DIRS[curDirection][1];
            if (!cleaned.contains(nx + " " + ny) && robot.move()) {
                clean(robot, nx, ny, curDirection, cleaned);
                goBack(robot);
            }
            robot.turnRight();
            curDirection = (curDirection + 1) % 4;
        }

    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
