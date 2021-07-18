package Interval;

import java.util.TreeMap;

/*
Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]
* */
public class MyCalendarI {
    TreeMap<Integer, Integer> calendar;

    MyCalendarI() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next))
        {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
