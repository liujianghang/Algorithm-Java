package class01.class01Copy;

public class Code03_InsertionSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 插入排序：实际上就是两边循环，让每一个元素从后往前移，插入到一个合适的位置
        // 此一次循环后 前两个位置有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
