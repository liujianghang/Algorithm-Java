package Algorithm.basic.class01.class01Copy;


public class Code07_EvenTimesOddTimes {
    /**
     * 如一组数中只有1个数是奇数个，其他数都是偶数个，找出这个数
     * 这里主要用到了 "位运算"
     * 偶数个相同的数位异或结果为0 0与任何数异或结果为任何数
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        System.out.println(eor);
    }

    /**
     * 如一组数中只有2个数是奇数个，其他数都是偶数个，找出这2个数
     * 这里需要一个 "某一位有差异"的思想
     * 与运算：相同为1，不同为0
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0, eor1 = 0;
        for (int num : arr) {
            eor ^= num;  // 这样得到的eor一定是一个有二进制有1位是1的数
        }
        int rightOne = eor & (~eor + 1);  // 这个数与这个数的补码与运算 找到右边第一位为1的那一位，如00000100
        for (int cur : arr) {
            if ((cur & rightOne) != 0) { // 找到差异数 (有的数是偶数个不影响结果)
                eor1 ^= cur;
            }
        }
        System.out.println(eor1 + ' ' + (eor ^ eor1)); // eor1 = a, eor = a^b, eor ^ eor1=a^a^b = b
    }
}

