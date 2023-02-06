package Algorithm.basic.class01.class01Copy;

public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 选择排序：将位序为1到length-1的元素选择其中最小的元素放到 1到length-1的位序上
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i; // 记住当前循环位序
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

