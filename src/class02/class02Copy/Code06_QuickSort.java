package Algorithm.basic.class02.class02Copy;

public class Code06_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // l是最大小于分割数的数的数组下标
            // 快排3.0 随机选择分割数放在末尾
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // p是一个长度为2的，值为中间数的数组下标的数组
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        // 以下是快速排序过程，此时r位置上已经是被随机过的值

        int less = l - 1; // 小于区左边界
        int more = r;  // 大于区右边界
        while (l < more) { // l表示当前数的位置
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 最后l会等于more 此时再交换 这时候more一定是右边界
        swap(arr, more, r);
        // 返回等于的区域的左边界和右边界
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
