package Design;

import java.util.LinkedList;
import java.util.Queue;

/*

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.

* */
public class MovingAverageDataStream {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 0;
    double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverageDataStream(int size) {
        capacity = size;
    }

    public double next(int val) {
        if(queue.size() == capacity)
        {
            sum -= queue.poll();
        }

        sum += val;
        queue.add(val);

        return sum/queue.size();
    }
}
