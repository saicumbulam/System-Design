package Math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null) return 0;

        int solution = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j].x - points[i].x;
                int deltaY = points[j].y - points[i].y;

                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;

                map.put(dX + "," + dY,
                        map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max,
                        map.get(dX + "," + dY));
            }

            solution = Math.max(solution, max + duplicate + 1);
        }

        return solution;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
