package class02.class02Copy;

/**
 * 求小和， 每个数左边有多少个数比他小？然后找出所有的数左边比他小的数的和
 * 再相加起来
 * 实际上可以看作是归并排序的一个拓展
 */
public class Code02_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        // 总小和数
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0; // 这趟merge可以产生的小和数
        while (p1 <= m && p2 <= r) {
            // 因为左右两组都是有序的 所以一定有当arr[p1] < ar'r[p2]时，arr[p2]右边的所有数都会比arr[p1]大 这时候res就可以加上了
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}