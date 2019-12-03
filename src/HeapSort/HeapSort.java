package HeapSort;

/**
 * @program: SortAlgorithm
 * @description: 堆排序
 * @author: Ya
 * @create: 2019-12-03 22:39
 **/
public class HeapSort {
    public static void heapSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        initMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustMaxHeap(array, i);
        }

    }

    /**
     * 初始化大根堆
     */
    private static void initMaxHeap(int[] a) {
        int parent;
        int cur;
        for (int i = 1; i < a.length; i++) {
            cur = i;
            parent = (cur - 1) >> 1;
            while (cur > 0 && a[cur] > a[parent]) {
                swap(a, cur, parent);
                cur = parent;
                parent = (cur - 1) >> 1;
            }
        }
    }

    /**
     * 调整大根堆
     */
    private static void adjustMaxHeap(int[] a, int len) {
        int cur = 0;
        int l, r, max;
        while ((cur << 1 + 1) < len) {
            l = (cur << 1) + 1;
            r = (cur << 1) + 2;
            if (a[l] < a[r] && r < len) {
                max = r;
            } else {
                max = l;
            }
            if (a[cur] < a[max]) {
                swap(a, cur, max);
                cur = max;
            } else {
                return;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }


    public static void main(String[] args) {
        int[] a = {4, 7, 1, 2, 8, 9, 1};
        heapSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
