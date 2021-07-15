package Math;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] arr) {

        Set<String> hs = new HashSet<>();
        for(int[] p: arr)
            hs.add(p[0] + "#" + p[1]);

        int min = Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++)
        {
            for(int j= i+1; j< arr.length; j++)
            {
                int[] point1 = arr[i]; //x,y
                int[] point2 = arr[j]; //x1,y1

                if(point1[0]==point2[0] || point1[1]==point2[1])
                    continue;

                String p1 = point1[0] + "#" + point2[1];  //x,y1
                String p2 = point2[0] + "#" + point1[1]; //x1,y
                if(hs.contains(p1)&&hs.contains(p2))
                {
                    int area = Math.abs((point1[0]-point2[0])*(point1[1]-point2[1]));
                    min = Math.min(min, area);
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
