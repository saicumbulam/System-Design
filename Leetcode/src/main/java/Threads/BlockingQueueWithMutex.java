package Threads;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithMutex {
    int[] array;
    Lock lock = new ReentrantLock();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BlockingQueueWithMutex(int capacity) {
        array = new int[capacity];
        Arrays.fill(array, -1);
        this.capacity = capacity;
    }

    public int dequeue() throws InterruptedException {

        int item = 0;

        lock.lock();
        while (size == 0) {
            lock.unlock();
            lock.lock();
        }

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = -1;
        head++;
        size--;

        lock.unlock();
        return item;
    }

    public void enqueue(int item) throws InterruptedException {

        lock.lock();
        while (size == capacity) {
            // Release the mutex to give other threads
            lock.unlock();
            // Reacquire the mutex before checking the
            // condition
            lock.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        lock.unlock();
    }
}
