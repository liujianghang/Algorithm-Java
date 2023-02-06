package Algorithm.basic.class02.class02Copy;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
    // TODO:处理一个最多移动距离不大于K的近似有序的数组，如何排序？
    // TODO:利用到小根堆 优先级队列就是堆 会自动扩容
    // TODO:这种堆不能实现某个位置的值改变，不然只能手写堆
    public static void sortArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 最多加入前k个数
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        // 加入一个，弹出一个
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

}
