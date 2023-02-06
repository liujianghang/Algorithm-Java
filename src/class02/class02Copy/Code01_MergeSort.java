package Algorithm.basic.class02.class02Copy;

public class Code01_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        // 对左边mergeSort 对右边mergeSort 最后再进行一次merge
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 第一次调用其实是最后一遍merge
        merge(arr, l, mid, r);
    }

    // 真正的通过空间合并的函数
    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0; // 用于辅佐help空间的指针
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 以下两个循环只会执行一个
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // 复制过程
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
