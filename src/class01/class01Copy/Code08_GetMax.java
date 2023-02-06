package Algorithm.basic.class01.class01Copy;

/**
 * 本体的目的是为了引出一个master公式， Tn = a*T(n/b) + O^d
 * log a b 与 d 进行比较
 */
public class Code08_GetMax {
    public static void getMax(int[] arr, int L, int R) {
        int res = process(arr, L, R);
        System.out.println(res);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) { //！ 如果范围上只有一个数
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);
        return Math.max(left, right);
    }
}
