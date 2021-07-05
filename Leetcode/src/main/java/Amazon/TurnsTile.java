package Amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TurnsTile {
    public static void main(String[] args) {

    }

    public static List<Integer> getTimes(int numworker, List<Integer> arrTime, List<Integer> direction) {

        ArrayDeque<Map.Entry<Integer, Integer>> enterQueue = new ArrayDeque<>();
        ArrayDeque<Map.Entry<Integer, Integer>> exitQueue = new ArrayDeque<>();

        int curTime = -1;

        String lastUsedType = "exit";

        for (int i = 0; i < numworker; i++) {

            //if (direction.get(i) == 0) enterQueue.offer((arrTime.get(i), i));

            //else exitQueue.offer(Map.entry(arrTime.get(i), i));

        }

        List<Integer> ans = Arrays.asList(new Integer[numworker]);

        while (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {

            ArrayDeque<Map.Entry<Integer, Integer>> curQueue;

            if (enterQueue.peek().getKey() <= curTime && exitQueue.peek().getKey() <= curTime) {

                if (curTime == -1 || lastUsedType == "exit")

                    curQueue = exitQueue;

                else

                    curQueue = enterQueue;

            } else if (enterQueue.peek().getKey() < exitQueue.peek().getKey()) {

                curQueue = enterQueue;

            } else {

                curQueue = exitQueue;

            }

            Map.Entry<Integer, Integer> worker = curQueue.poll();

            int time = worker.getKey();

            int i = worker.getValue();

            lastUsedType = curQueue == enterQueue ? "enter" : "exit";

            curTime = Math.max(time, curTime);

            ans.set(i, curTime);

            curTime++;

        }

        ArrayDeque<Map.Entry<Integer, Integer>> remainingQueue = !enterQueue.isEmpty() ? enterQueue : exitQueue;

        while (!remainingQueue.isEmpty()) {

            Map.Entry<Integer, Integer> worker = remainingQueue.poll();

            int time = worker.getKey();

            int i = worker.getValue();

            curTime = Math.max(time, curTime);

            ans.set(i, curTime);

            curTime++;

        }

        return ans;

    }
}
