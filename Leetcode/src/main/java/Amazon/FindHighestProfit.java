package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindHighestProfit {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        int order = 5;

        System.out.println(Calculate(list, order));
    }



    public static int Calculate(List<Integer> arr, int order) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(arr);

        int profit = 0;

        for (int i = 0; i < order && !maxHeap.isEmpty(); i++) {

            int stock = maxHeap.poll();
            profit += stock;
            stock--;
            if (stock > 0) maxHeap.offer(stock);
        }

        return profit;
    }
}
