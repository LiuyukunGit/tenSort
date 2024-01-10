package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.util.Arrays;

public class QuickSort {
    public void sortFunction(int[] array, int low, int high) {
        if (low < high) {
            int pivot = array[low];
            int i = low;
            int j = high;
            while (i < j) {
                while ((i < j) && array[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }
                while ((i < j) && array[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = pivot;
            sortFunction(array, low, i - 1);
            sortFunction(array, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        QuickSort quickSort = new QuickSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
//        排序
        long beginTime = System.currentTimeMillis();
        quickSort.sortFunction(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
