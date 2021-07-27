package Array;

import java.util.PriorityQueue;

/*
Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
Output: [0,2,3,1]
Explanation: The events go as follows:
- At time = 1, task 0 is available to process. Available tasks = {0}.
- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
- At time = 2, task 1 is available to process. Available tasks = {1}.
- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest.
Available tasks = {1}.
- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest.
Available tasks = {1}.
- At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
- At time = 10, the CPU finishes task 1 and becomes idle.
* */
public class SingleThreadedCPU {
    class Task {
        int index,enqueueTime,processingTime;
        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((x, y)-> x.enqueueTime-y.enqueueTime);
        PriorityQueue<Task> availableQueue = new PriorityQueue<>(
                        (x, y)->x.processingTime!=y.processingTime ?
                                x.processingTime-y.processingTime : x.index-y.index);
        int[] result = new int[tasks.length];
        for(int i=0;i<tasks.length;i++)
            taskQueue.offer(new Task(i, tasks[i][0], tasks[i][1]));

        int index=0;
        int currentTime = taskQueue.peek().enqueueTime;

        while(!taskQueue.isEmpty() || !availableQueue.isEmpty())
        {
            while(!taskQueue.isEmpty() && taskQueue.peek().enqueueTime <= currentTime)
                availableQueue.offer(taskQueue.poll());

            if(!availableQueue.isEmpty())
            {
                currentTime = currentTime + availableQueue.peek().processingTime;
                result[index++] = availableQueue.poll().index;
            }
            else
                currentTime = taskQueue.peek().enqueueTime;
        }
        return result;
    }
}

