package Design;

import java.util.*;

public class TheSkylineProblem {
    class BuildingPoint implements Comparator<BuildingPoint>
    {
        int x;
        int height;
        boolean start;

        public BuildingPoint(int x, int height, boolean start)
        {
            this.x = x;
            this.height = height;
            this.start = start;
        }

        public BuildingPoint()
        {

        }

        public int compare(BuildingPoint b1, BuildingPoint b2)
        {
            if(b1.x == b2.x)
            {
                if (b1.start && b2.start) return b2.height - b1.height;
                if (!b1.start && !b2.start) return b1.height - b2.height;
                if (b1.start && !b2.start) return -1;
                if (!b1.start && b2.start) return 1;
            }
            return b1.x - b2.x;
        }
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {

        BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];

        int k = 0;

        for (int[] building : buildings)
        {
            buildingPoints[k++] = new BuildingPoint(building[0], building[2], true);
            buildingPoints[k++] = new BuildingPoint(building[1], building[2], false);
        }

        Arrays.sort(buildingPoints, new BuildingPoint());

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 0);
        int previousHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (BuildingPoint item: buildingPoints)
        {
            if (item.start)
            {
                map.compute(item.height, (key, value) -> {
                    if (value == null)
                        return 1;
                    return value+1;
                });
            }
            else
            {
                map.compute(item.height, (key, value) -> {
                    if (value == 1)
                        return null;
                    value -= 1;
                    return value;
                });

            }

            if (map.firstKey() != previousHeight)
            {
                previousHeight = map.firstKey();
                result.add(Arrays.asList(item.x, map.firstKey()));
            }
        }

        return result;
    }
}
