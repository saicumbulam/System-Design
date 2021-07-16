package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    class Interval
    {
        int start;
        int end;

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) ->
                a.end - b.end);
        List<Interval> list = new ArrayList<>();
        for(int[] item: intervals)
        {
            list.add(new Interval(item[0], item[1]));
        }


        int maximum = 0;
        for(int i = 0; i < list.size(); i++)
        {
            while(!minHeap.isEmpty() && minHeap.peek().end <= list.get(i).start)
            {
                minHeap.poll();
            }

            minHeap.add(list.get(i));
            maximum = Math.max(minHeap.size(), maximum);
        }

        return maximum;
    }
}
