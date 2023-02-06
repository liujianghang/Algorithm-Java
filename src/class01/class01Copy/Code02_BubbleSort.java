package class01.class01Copy;

public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 冒泡排序：从0到length-1每次将相邻的两个元素比较，如果前一个比后一个大，就后移
        // 从后往前的一个倒序可能更好理解
        for (int e = arr.length; e > 0; e--) {
            for (int j = 0; j < e; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
