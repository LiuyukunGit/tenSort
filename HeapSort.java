package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import algorithm.utils.GenerateArray;

import java.util.Arrays;

public class HeapSort {

    public void swap(int[] array, int index1, int index2) {
        array[index1] = array[index1] ^ array[index2];
        array[index2] = array[index1] ^ array[index2];
        array[index1] = array[index1] ^ array[index2];
    }

    //    向下调整
    public void downAdjust(int[] array, int index, int arrayLength) {
        if (index > (arrayLength - 2) >> 1) {
            return;
//            单子叶
        } else if ((index * 2) + 2 >= arrayLength) {
            if (array[(index * 2) + 1] > array[index]) {
                swap(array, (index * 2) + 1, index);
            }
        } else {
            if (array[(index * 2) + 2] > array[index] && array[(index * 2) + 2] >= array[(index * 2) + 1]) {
                swap(array, (index * 2) + 2, index);
                downAdjust(array, (index * 2) + 2, arrayLength);
            } else if (array[(index * 2) + 1] > array[index] && array[(index * 2) + 1] > array[(index * 2) + 2]) {
                swap(array, (index * 2) + 1, index);
                downAdjust(array, (index * 2) + 1, arrayLength);
            }
        }
    }

    //    初始化大根堆
    public void initHeap(int[] array, int arrayLength) {
        boolean hasTwochild = (arrayLength % 2) == 1 ? true : false;
        for (int i = (arrayLength - 2) >> 1; i >= 0; i--) {
            if (hasTwochild) {
                if (array[(i * 2) + 2] > array[i] && array[(i * 2) + 2] >= array[(i * 2) + 1]) {
                    swap(array, (i * 2) + 2, i);
                    downAdjust(array, (i * 2) + 2, arrayLength);
                } else if (array[(i * 2) + 1] > array[i] && array[(i * 2) + 1] > array[(i * 2) + 2]) {
                    swap(array, (i * 2) + 1, i);
                    downAdjust(array, (i * 2) + 1, arrayLength);
                }
            } else {
                if (array[(i * 2) + 1] > array[i]) {
                    swap(array, (i * 2) + 1, i);
                }
                hasTwochild = true;
            }
        }
    }

    public void sortFunction(int[] array) {
        int arrayLength = array.length;
//        初始化堆
        for (int i = array.length - 1; i > 0; i--) {
            initHeap(array, arrayLength);
            swap(array, i, 0);
            arrayLength--;
        }
    }

    public static void main(String[] args) {
        int arrayLength = 100000;
        int[] array = new int[arrayLength];
        HeapSort heapSort = new HeapSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        heapSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
