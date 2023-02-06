package class02.class02Copy;

public class Code03_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { // O(n)
            heapInsert(arr, i);   // O(log n)
        }
        int size = arr.length;
        swap(arr, 0, --size);  // 以此拿出
        while (size > 0) {       // O(n)
            heapify(arr, 0, size);  //O(log n)
            swap(arr, 0, --size);  // 拿出
        }
    }

    public static void heapInsert(int[] arr, int index) {
        // TODO:上移过程
        while (arr[index] > arr[index - 1] / 2) {  // 找到父节点并比较
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        // TODO:下移过程:与上移不同的是要确定是否有子孩子 找到较大的一个并比较
        int left = index * 2 + 1;
        while (left < size) {  // 当存在子节点的时候
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest; // 继续下移
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
